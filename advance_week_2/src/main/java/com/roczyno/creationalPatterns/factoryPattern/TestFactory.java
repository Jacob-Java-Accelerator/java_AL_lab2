package com.roczyno.creationalPatterns.factoryPattern;

import com.roczyno.creationalPatterns.factoryPattern.databaseConn.DatabaseConnection;
import com.roczyno.creationalPatterns.factoryPattern.databaseConn.DatabaseConnectionFactory;
import com.roczyno.creationalPatterns.factoryPattern.shapes.Shape;
import com.roczyno.creationalPatterns.factoryPattern.shapes.ShapeFactory;

import java.util.HashMap;

public class TestFactory {

	public static void main(String[] args) {
		Shape circle = ShapeFactory.createShape("circle");
		circle.draw();

		// Test db connection
		HashMap<String, String> config = new HashMap<>();
		config.put("type", "mysql");
		config.put("host", "localhost");
		config.put("username", "jacob");
		config.put("password", "sweetpotato123");

		DatabaseConnection dbConn = DatabaseConnectionFactory.createConnection(config);
		dbConn.connect();

	}
}
