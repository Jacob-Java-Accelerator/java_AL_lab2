package com.elitekaycy.testlabs.labs.simpleService;

public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User getUser(String name) {
    return userRepository.findUserByName(name);
  }
}
