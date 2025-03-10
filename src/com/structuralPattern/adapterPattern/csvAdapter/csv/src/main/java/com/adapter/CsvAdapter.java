package com.adapter;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CsvAdapter implements DataSource {

  private String filePath;

  public CsvAdapter(String filePath) {
    this.filePath = filePath;
  }

  @Override
  public List<String[]> readData() throws IOException {
    List<String[]> data = new ArrayList<>();
    try (Reader reader = Files.newBufferedReader(Paths.get(filePath));
        CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);) {

      for (CSVRecord record : parser) {
        String[] recordValues = new String[record.size()];
        for (int i = 0; i < record.size(); i++) {
          recordValues[i] = record.get(i);
        }
        data.add(recordValues);
      }

    }
    return data;
  }

}
