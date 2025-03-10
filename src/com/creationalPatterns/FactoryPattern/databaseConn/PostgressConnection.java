package com.creationalPatterns.FactoryPattern.databaseConn;

public class PostgressConnection implements DatabaseConnection {
  private String host;
  private String username;
  private String password;

  public PostgressConnection(String host, String username, String password) {
    this.host = host;
    this.username = username;
    this.password = password;
  }

  @Override
  public void connect() {
    System.out.println("connected to postgressql {" + username + "}:" + "{" + password + "}@{" + host + "}");
  }
}
