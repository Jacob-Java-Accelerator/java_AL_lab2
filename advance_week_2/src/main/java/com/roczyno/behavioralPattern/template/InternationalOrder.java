package com.roczyno.behavioralPattern.template;

public class InternationalOrder extends OrderProcessor {
	@Override
	protected void calculateShipping() {
		System.out.println("Calculating international shipping cost + customs fees.");
	}
}
