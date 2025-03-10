package com.creationalPatterns.BuilderPattern;

public class TestBuilder {

  public static void main(String[] args) {

    User user = new User.Builder()
        .name("dickson")
        .email("dickson@1234@gmail.com")
        .build();

    System.out.println(user.toString());

  }
}
