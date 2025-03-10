package com.structuralPattern.adapterPattern.legacyPayment;

public class ModernPaymentProcessImpl implements ModernPaymentProcessor {

  @Override
  public void initializePayment(String cardNumber, String expirationDate, String securityCode) {
    System.out.println("Payment initialized with card number: " + cardNumber + ", expiration date: " + expirationDate
        + ", security code: " + securityCode);
  }

}
