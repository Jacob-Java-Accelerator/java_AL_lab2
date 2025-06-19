package com.roczyno.behavioralPattern.strategy.sorting;

public class SelectionSortStrategy implements SortingStrategy {
	@Override
	public void sort(int[] numbers) {
		System.out.println("Using Selection Sort...");
		for (int i = 0; i < numbers.length - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[j] < numbers[minIdx]) {
					minIdx = j;
				}
			}
			int temp = numbers[minIdx];
			numbers[minIdx] = numbers[i];
			numbers[i] = temp;
		}
	}
}

