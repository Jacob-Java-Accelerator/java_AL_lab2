package com.elitekaycy.testlabs.labs.simpleService;

public class UserRepositoryImpl implements UserRepository {
	@Override
	public User findUserByName(String name) {
		return new User(name, "jacob@gmail.com");
	}
}

