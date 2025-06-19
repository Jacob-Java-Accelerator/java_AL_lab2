package com.roczyno.behavioralPattern.strategy.compression;

public class Compressor {
	private CompressionStrategy strategy;

	public void setStrategy(CompressionStrategy strategy) {
		this.strategy = strategy;
	}

	public void compress(String fileName) {
		strategy.compress(fileName);
	}
}

