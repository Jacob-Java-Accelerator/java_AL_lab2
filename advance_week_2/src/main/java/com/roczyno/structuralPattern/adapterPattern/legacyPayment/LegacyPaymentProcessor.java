package com.roczyno.structuralPattern.adapterPattern.legacyPayment;

public interface LegacyPaymentProcessor {
	void legacyPaymentProcess(String name, String cardNo, String cvv, String expDate);
}
