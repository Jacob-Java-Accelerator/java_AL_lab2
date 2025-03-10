package com.creationalPatterns.singleton;

public class Logger {

  private static final Logger instance = new Logger();

  public Logger() {
  };

  public static Logger getInstance() {
    return instance;
  }

  public void log(String msg) {
    System.out.println("[INFO]" + " " + msg);
  }
}
