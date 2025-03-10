package com.structuralPattern.adapterPattern.legacyPayment;

public class TestPaymentProcessor {

  public static void main(String[] args) {
    LegacyPaymentProcessor legacyPaymentProcessor = new LegacyPaymentProcessorImpl();

    PaymentAdapter paymentAdapter = new PaymentAdapter(legacyPaymentProcessor);

    paymentAdapter.initializePayment("USD", "1234567890", "1234567890");

  }

}
