package com.roczyno.behavioralPattern.strategy.sorting;

public class SortingApp {
	public static void main(String[] args) {
		int[] numbers = {5, 3, 8, 1, 2};

		Sorter sorter = new Sorter();

		sorter.setStrategy(new BubbleSortStrategy());
		sorter.sort(numbers);

		System.out.println(java.util.Arrays.toString(numbers));

		sorter.setStrategy(new SelectionSortStrategy());
		sorter.sort(numbers);

		System.out.println(java.util.Arrays.toString(numbers));
	}
}
