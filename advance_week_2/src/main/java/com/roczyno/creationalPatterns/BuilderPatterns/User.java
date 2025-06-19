package com.roczyno.creationalPatterns.BuilderPatterns;

public class User {
	private final String name;
	private final String username;
	private final String email;

	private User(Builder builder) {
		this.name = builder.name;
		this.username = builder.username;
		this.email = builder.email;
	}

	public String getName() {
		return name;
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}

	public static class Builder {
		private String name;
		private String username;
		private String email;

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder username(String username) {
			this.username = username;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public User build() {
			if (this.name == null) {
				throw new IllegalStateException("name is required");
			}
			return new User(this);
		}
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", username=" + username + ", email=" + email + "]";
	}
}
