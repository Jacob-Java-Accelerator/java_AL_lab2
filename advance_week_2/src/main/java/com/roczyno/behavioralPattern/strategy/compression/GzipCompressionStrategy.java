package com.roczyno.behavioralPattern.strategy.compression;

public class GzipCompressionStrategy implements CompressionStrategy {
	@Override
	public void compress(String fileName) {
		System.out.println("Compressing " + fileName + " using GZIP compression.");
	}
}
