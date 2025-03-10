package com.elitekaycy.testlabs.labs.simpleService;

public class UserRepository {

  public UserRepository() {
  }

  public User findUserByName(String name) {
    return new User(name, "dickson@1234.com");
  }

}
