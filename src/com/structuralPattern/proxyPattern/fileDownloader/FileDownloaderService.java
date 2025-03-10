package com.structuralPattern.proxyPattern.fileDownloader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

interface FileDownloader {
  void downloadFile(String url) throws Exception;
}

class FileDownloaderImpl implements FileDownloader {

  @Override
  public void downloadFile(String url) throws Exception {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(new URI(url))
        .build();

    HttpResponse<InputStream> response = client.send(request, BodyHandlers.ofInputStream());

    if (response.statusCode() != 200) {
      throw new IOException("Failed to download file: " + response.statusCode());
    }

    long fileSize = response.headers().firstValueAsLong("content-length").orElse(-1);
    if (fileSize == -1) {
      throw new IOException("Failed to get file size");
    }

    try (InputStream in = response.body();
        FileOutputStream out = new FileOutputStream("downloaded_file")) {
      byte[] buffer = new byte[4096];
      int bytesRead;
      long totalBytesRead = 0;

      while ((bytesRead = in.read(buffer)) != -1) {
        out.write(buffer, 0, bytesRead);
        totalBytesRead += bytesRead;
        int progress = (int) ((totalBytesRead / (float) fileSize) * 100);
        System.out.print("\rDownloading... " + progress + "%");
      }
    }

    System.out.println("\nDownload complete!");
  }
}

class ProxyFileDownloader implements FileDownloader {
  private FileDownloaderImpl fileDownloader;
  private String authorizedToken;

  public ProxyFileDownloader(String authorizedToken) {
    this.fileDownloader = new FileDownloaderImpl();
    this.authorizedToken = authorizedToken;
  }

  @Override
  public void downloadFile(String url) throws Exception {
    if (isAuthorized()) {
      fileDownloader.downloadFile(url);
    } else {
      System.out.println("Authorization failed. Download not allowed.");
    }
  }

  private boolean isAuthorized() {
    return "VALID_TOKEN".equals(authorizedToken);
  }
}

public class FileDownloaderService {
  public static void main(String[] args) throws Exception {
    String authorizedToken = "VALID_TOKEN";
    String unauthorizedToken = "INVALID_TOKEN";

    FileDownloader downloader = new ProxyFileDownloader(authorizedToken);
    FileDownloader downloaderInvalid = new ProxyFileDownloader(unauthorizedToken);

    downloader.downloadFile("https://jsonplaceholder.typicode.com/todos/1");
    downloaderInvalid.downloadFile("https://jsonplaceholder.typicode.com/todos/1");
  }
}
