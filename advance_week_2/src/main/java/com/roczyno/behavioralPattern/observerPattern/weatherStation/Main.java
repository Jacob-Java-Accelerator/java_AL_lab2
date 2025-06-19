package com.roczyno.behavioralPattern.observerPattern.weatherStation;

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
