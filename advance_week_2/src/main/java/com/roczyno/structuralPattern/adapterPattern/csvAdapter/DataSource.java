package com.roczyno.structuralPattern.adapterPattern.csvAdapter;

import java.io.IOException;
import java.util.List;

public interface DataSource {
	List<String[]> readData() throws IOException;
}
