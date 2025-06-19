package com.roczyno.structuralPattern.adapterPattern.legacyPayment;


public class TestPaymentProcessor {
	public static void main(String[] args) {
		LegacyPaymentProcessor legacyPaymentProcessor = new LegacyPaymentProcessorImpl();
		ModernPaymentProcessor paymentAdapter = new PaymentAdapter(legacyPaymentProcessor);

		paymentAdapter.initializePayment("1234-5678-9012-3456", "12/27", "123");
	}
}

