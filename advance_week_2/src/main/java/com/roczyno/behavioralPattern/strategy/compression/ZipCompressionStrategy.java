package com.roczyno.behavioralPattern.strategy.compression;

public class ZipCompressionStrategy implements CompressionStrategy {
	@Override
	public void compress(String fileName) {
		System.out.println("Compressing " + fileName + " using ZIP compression.");
	}
}

