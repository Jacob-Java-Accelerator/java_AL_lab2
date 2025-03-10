package com.behaviouralPattern.observerPattern.weatherStation;

public interface Observer {
  void update(float temperature, float humidity, float pressure);
}
