package com.roczyno.behavioralPattern.template;

public abstract class OrderProcessor {

	// Template method
	public final void processOrder() {
		validateOrder();
		calculateShipping();
		processPayment();
		sendConfirmation();
	}

	// Default implementations
	protected void validateOrder() {
		System.out.println("Validating order...");
	}

	protected abstract void calculateShipping(); // varies

	protected void processPayment() {
		System.out.println("Processing payment...");
	}

	protected void sendConfirmation() {
		System.out.println("Sending order confirmation...");
	}
}
