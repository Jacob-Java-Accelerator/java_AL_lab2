package com.roczyno.behavioralPattern.template;

public class DomesticOrder extends OrderProcessor {
	@Override
	protected void calculateShipping() {
		System.out.println("Calculating domestic shipping cost.");
	}
}

