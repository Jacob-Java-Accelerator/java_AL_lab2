package com.structuralPattern.adapterPattern.legacyPayment;

public class LegacyPaymentProcessorImpl implements LegacyPaymentProcessor {

  @Override
  public void legacyPaymentProcess(String name, String cardNo, String cvv, String expDate) {
    System.out.println("processing payment with legacy payment gateway");
    System.out.println("name: " + name);
    System.out.println("cardNo: " + cardNo);
    System.out.println("cvv: " + cvv);
    System.out.println("expDate: " + expDate);
  }

}
