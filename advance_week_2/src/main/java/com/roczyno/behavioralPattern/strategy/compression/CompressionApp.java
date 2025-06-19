package com.roczyno.behavioralPattern.strategy.compression;

public class CompressionApp {
	public static void main(String[] args) {
		Compressor compressor = new Compressor();

		compressor.setStrategy(new ZipCompressionStrategy());
		compressor.compress("report.pdf");

		compressor.setStrategy(new GzipCompressionStrategy());
		compressor.compress("logfile.txt");
	}
}

