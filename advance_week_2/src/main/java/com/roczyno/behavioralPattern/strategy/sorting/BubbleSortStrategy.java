package com.roczyno.behavioralPattern.strategy.sorting;

public class BubbleSortStrategy implements SortingStrategy {
	@Override
	public void sort(int[] numbers) {
		System.out.println("Using Bubble Sort...");
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = 0; j < numbers.length - 1 - i; j++) {
				if (numbers[j] > numbers[j + 1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
		}
	}
}
