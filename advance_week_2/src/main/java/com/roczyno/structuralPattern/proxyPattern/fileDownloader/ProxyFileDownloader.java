package com.roczyno.structuralPattern.proxyPattern.fileDownloader;

class ProxyFileDownloader implements FileDownloader {
	private FileDownloaderImpl fileDownloader;
	private String authorizedToken;

	public ProxyFileDownloader(String authorizedToken) {
		this.fileDownloader = new FileDownloaderImpl();
		this.authorizedToken = authorizedToken;
	}

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

