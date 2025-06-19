package com.roczyno.creationalPatterns.factoryPattern.databaseConn;

import java.util.HashMap;

public class TestFactory {
	public static void main(String[] args) {
		HashMap<String, String> config = new HashMap<>();
		config.put("type", "postgresql");
		config.put("host", "localhost");
		config.put("username", "jacob");
		config.put("password", "admin123");

		DatabaseConnection dbConn = DatabaseConnectionFactory.createConnection(config);
		dbConn.connect();
	}
}

