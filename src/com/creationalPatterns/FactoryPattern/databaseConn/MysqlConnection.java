package com.creationalPatterns.FactoryPattern.databaseConn;

public class MysqlConnection implements DatabaseConnection {
  private String host;
  private String username;
  private String password;

  public MysqlConnection(String host, String username, String password) {
    this.host = host;
    this.username = username;
    this.password = password;
  }

  @Override
  public void connect() {
    System.out.println("connected to mysql {" + username + "}:" + "{" + password + "}@{" + host + "}");
  }

}
