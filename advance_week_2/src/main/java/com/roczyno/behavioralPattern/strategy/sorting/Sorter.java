package com.roczyno.behavioralPattern.strategy.sorting;

public class Sorter {
	private SortingStrategy strategy;

	public void setStrategy(SortingStrategy strategy) {
		this.strategy = strategy;
	}

	public void sort(int[] numbers) {
		strategy.sort(numbers);
	}
}

