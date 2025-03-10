package com.structuralPattern.facadePattern.shoppingCart;

public class Discount {

  public Discount(String discountCode, int amount) {
    this.discountCode = discountCode;
    this.amount = amount;
  }

  public Discount() {
  }

  private String discountCode;
  private int amount;

  public String getDiscountCode() {
    return discountCode;
  }

  public void setDiscountCode(String discountCode) {
    this.discountCode = discountCode;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

}
