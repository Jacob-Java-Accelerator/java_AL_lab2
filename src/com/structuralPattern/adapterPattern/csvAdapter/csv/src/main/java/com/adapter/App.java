package com.adapter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class App {
  public static void main(String[] args) throws IOException {
    DataSource datasource = new CsvAdapter("src/main/resources/data.csv");

    List<String[]> data = datasource.readData();

    for (String[] record : data) {
      System.out.println(Arrays.toString(record));
    }
  }
}
