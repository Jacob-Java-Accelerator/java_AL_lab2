package com.creationalPatterns.BuilderPattern;

public class User {
  private String name;
  private String username;
  private String email;

  public User(String name, String username, String email) {
    this.name = name;
    this.username = username;
    this.email = email;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setEmail(String email) {
    this.email = email;
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
      return new User(name, username, email);
    }

  }

  @Override
  public String toString() {
    return "User [name=" + name + ", username=" + username + ", email=" + email + "]";
  }

}
