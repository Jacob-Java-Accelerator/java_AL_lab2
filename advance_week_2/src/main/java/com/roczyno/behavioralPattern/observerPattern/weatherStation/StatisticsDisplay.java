package com.roczyno.behavioralPattern.observerPattern.weatherStation;

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

