package com.creationalPatterns.singleton;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManager {

  private static ConfigurationManager instance;
  private Properties properties;

  private ConfigurationManager() {
    properties = new Properties();
    loadPropertiesFromFile();
    loadPropertiesFromEnvironment();
  }

  public static synchronized ConfigurationManager getInstance() {
    if (instance == null) {
      instance = new ConfigurationManager();
    }
    return instance;
  }

  private void loadPropertiesFromFile() {
    try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
      if (input != null) {
        properties.load(input);
      } else {
        System.err.println("Configuration file 'config.properties' not found in the classpath");
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  private void loadPropertiesFromEnvironment() {
    for (String key : properties.stringPropertyNames()) {
      String envValue = System.getenv(key);
      if (envValue != null) {
        properties.setProperty(key, envValue);
      }
    }
  }

  public String getProperty(String key) {
    return properties.getProperty(key);
  }

  public String getProperty(String key, String defaultValue) {
    return properties.getProperty(key, defaultValue);
  }
}
