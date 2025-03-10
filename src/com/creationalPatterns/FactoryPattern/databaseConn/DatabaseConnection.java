package com.creationalPatterns.FactoryPattern.databaseConn;

public interface DatabaseConnection {

  default void connect() {
    System.out.println("connected successfully");
  };
}
