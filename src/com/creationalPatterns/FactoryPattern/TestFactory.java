package com.creationalPatterns.FactoryPattern;

import java.util.HashMap;

import com.creationalPatterns.FactoryPattern.databaseConn.DatabaseConnection;
import com.creationalPatterns.FactoryPattern.databaseConn.DatabaseConnectionFactory;
import com.creationalPatterns.FactoryPattern.shapes.Shape;
import com.creationalPatterns.FactoryPattern.shapes.ShapeFactory;

public class TestFactory {

  public static void main(String[] args) {
    Shape circle = ShapeFactory.createShape("circle");
    circle.draw();

    // Test db connection
    HashMap<String, String> config = new HashMap<>();
    config.put("type", "mysql");
    config.put("host", "localhost");
    config.put("username", "dickson");
    config.put("password", "sweetpotato123");

    DatabaseConnection dbConn = DatabaseConnectionFactory.createConnection(config);
    dbConn.connect();

  }
}
