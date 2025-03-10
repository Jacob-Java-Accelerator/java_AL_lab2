package com.structuralPattern.adapterPattern.legacyPayment;

public class PaymentAdapter implements ModernPaymentProcessor {

  private LegacyPaymentProcessor legacyPaymentProcessor;

  PaymentAdapter(LegacyPaymentProcessor paymentProcessor) {
    this.legacyPaymentProcessor = paymentProcessor;
  }

  @Override
  public void initializePayment(String cardNumber, String expirationDate, String securityCode) {

    String name = getCardName(cardNumber);
    this.legacyPaymentProcessor.legacyPaymentProcess(name, cardNumber, securityCode, expirationDate);
  }

  private String getCardName(String cardNumber) {
    return "John doe";
  }

}
