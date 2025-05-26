package com.roczyno.creationalPatterns.BuilderPatterns;

public class TestBuilder {

	public static void main(String[] args) {

		User user = new User.Builder()
				.name("jacob")
				.email("jacob@1234@gmail.com")
				.build();

		System.out.println(user.toString());

	}
}
