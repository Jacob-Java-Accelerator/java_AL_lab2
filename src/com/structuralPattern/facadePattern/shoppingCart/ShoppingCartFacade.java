package com.structuralPattern.facadePattern.shoppingCart;

public interface ShoppingCartFacade {
  void addItem(String itemId, int quantity);

  double calculateTotal();

  void applyDiscount(String discountCode);

  void initiateCheckout();
}
