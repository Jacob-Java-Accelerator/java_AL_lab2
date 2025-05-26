package com.roczyno.structuralPattern.adapterPattern.csvAdapter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AdapterPattern {
	public static void main(String[] args) throws IOException {
		DataSource datasource = new CsvAdapter("src\\main\\java\\com\\roczyno\\structuralPattern\\csvAdapter\\data.csv");

		List<String[]> data = datasource.readData();

		for (String[] record : data) {
			System.out.println(Arrays.toString(record));
		}
	}
}
