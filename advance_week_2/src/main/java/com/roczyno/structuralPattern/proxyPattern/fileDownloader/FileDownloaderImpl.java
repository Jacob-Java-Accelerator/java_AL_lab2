package com.roczyno.structuralPattern.proxyPattern.fileDownloader;

class FileDownloaderImpl implements FileDownloader {
	public void downloadFile(String url) throws Exception {
		System.out.println("Downloading " + url);
	}
}
