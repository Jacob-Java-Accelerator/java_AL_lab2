package com.behaviouralPattern.observerPattern.weatherStation;

class CurrentConditionsDisplay implements Observer {
  private float temperature;
  private float humidity;
  private Subject weatherStation;

  public CurrentConditionsDisplay(Subject weatherStation) {
    this.weatherStation = weatherStation;
    weatherStation.registerObserver(this);
  }

  @Override
  public void update(float temperature, float humidity, float pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    display();
  }

  public void display() {
    System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
  }
}

class StatisticsDisplay implements Observer {
  private float maxTemp = 0.0f;
  private float minTemp = 200;
  private float tempSum = 0.0f;
  private int numReadings;
  private Subject weatherStation;

  public StatisticsDisplay(Subject weatherStation) {
    this.weatherStation = weatherStation;
    weatherStation.registerObserver(this);
  }

  @Override
  public void update(float temperature, float humidity, float pressure) {
    tempSum += temperature;
    numReadings++;

    if (temperature > maxTemp) {
      maxTemp = temperature;
    }

    if (temperature < minTemp) {
      minTemp = temperature;
    }

    display();
  }

  public void display() {
    System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings) + "/" + maxTemp + "/" + minTemp);
  }
}

public class Main {
  public static void main(String[] args) {
    WeatherStation weatherStation = new WeatherStation();

    new CurrentConditionsDisplay(weatherStation);
    new StatisticsDisplay(weatherStation);

    weatherStation.setMeasurements(80, 65, 30.4f);
    weatherStation.setMeasurements(82, 70, 29.2f);
    weatherStation.setMeasurements(78, 90, 29.2f);
  }
}
