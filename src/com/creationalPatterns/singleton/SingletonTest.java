package com.creationalPatterns.singleton;

public class SingletonTest {

  public static void main(String[] args) {
    Logger logger = Logger.getInstance();

    logger.log("hello world");
  }
}
