package com.roczyno.creationalPatterns.singleton;

public class SingletonTest {

	public static void main(String[] args) {
//		Logger logger = Logger.getInstance();
//
//		logger.log("hello world");


		ConfigurationManager config = ConfigurationManager.getInstance();
		String dbUrl = config.getProperty("DB_URL", "jdbc:mysql://localhost:3306/default");
		System.out.println("Database URL: " + dbUrl);
	}
}
