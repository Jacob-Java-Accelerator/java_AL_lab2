package com.creationalPatterns.FactoryPattern.databaseConn;

import java.util.HashMap;

public class DatabaseConnectionFactory {
  public static DatabaseConnection createConnection(HashMap<String, String> config) {
    if (config.get("type") == "mysql") {
      return new MysqlConnection(config.get("host"), config.get("username"), config.get("password"));
    } else if (config.get("type") == "postgresql") {
      return new PostgressConnection(config.get("host"), config.get("username"), config.get("password"));
    } else {
      return new MysqlConnection(config.get("host"), config.get("username"), config.get("password"));
    }
  }
}
