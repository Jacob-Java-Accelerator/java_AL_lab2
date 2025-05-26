package com.roczyno.creationalPatterns.factoryPattern.databaseConn;

public interface DatabaseConnection {

	default void connect() {
		System.out.println("connected successfully");
	};
}
