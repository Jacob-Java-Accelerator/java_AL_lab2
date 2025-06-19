package com.roczyno.structuralPattern.proxyPattern.fileDownloader;

public class FileDownloaderService {
	public static void main(String[] args) throws Exception {
		FileDownloader downloader = new ProxyFileDownloader("VALID_TOKEN");
		FileDownloader downloaderInvalid = new ProxyFileDownloader("INVALID_TOKEN");

		downloader.downloadFile("https://jsonplaceholder.typicode.com/todos/1"); // Success
		downloaderInvalid.downloadFile("https://jsonplaceholder.typicode.com/todos/1"); // Blocked
	}
}
