package com.elitekaycy.testlabs.labs.simpleService;

public class UserServiceImpl  implements UserService{
  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User getUser(String name) {
    User user = userRepository.findUserByName(name);
    if (user == null) {
      throw new IllegalArgumentException("User not found for name: " + name);
    }
    if (!user.getName().equals(name)) {
      throw new IllegalArgumentException("Returned user has incorrect name.");
    }
    if (!user.getEmail().endsWith("@gmail.com")) {
      throw new IllegalArgumentException("Invalid email format.");
    }
    return user;
  }

}
