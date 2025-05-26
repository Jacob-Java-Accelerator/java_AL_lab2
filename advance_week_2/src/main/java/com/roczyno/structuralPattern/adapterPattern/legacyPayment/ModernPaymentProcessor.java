package com.roczyno.structuralPattern.adapterPattern.legacyPayment;

public interface ModernPaymentProcessor {
	void initializePayment(String cardNumber, String expirationDate, String securityCode);
}
