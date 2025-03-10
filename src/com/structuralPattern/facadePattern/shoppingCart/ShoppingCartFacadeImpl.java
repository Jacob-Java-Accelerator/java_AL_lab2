package com.structuralPattern.facadePattern.shoppingCart;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCartFacadeImpl implements ShoppingCartFacade {
  private ShoppingCart cart = new ShoppingCart();
  private Map<String, Product> products = new HashMap<>();
  private DiscountService discountService = new DiscountService();

  @Override
  public void addItem(String itemId, int quantity) {
    cart.addItem(itemId, quantity);
  }

  @Override
  public double calculateTotal() {
    return cart.calculateTotal(products);
  }

  @Override
  public void applyDiscount(String discountCode) {
    discountService.applyDiscount(discountCode, cart);
  }

  @Override
  public void initiateCheckout() {
    double total = calculateTotal();
    System.out.println("Initiating checkout with total: $" + total);
  }

  public static void main(String[] args) {
    ShoppingCartFacade shoppingCart = new ShoppingCartFacadeImpl();

    shoppingCart.addItem("001", 2);
    shoppingCart.addItem("002", 1);

    shoppingCart.applyDiscount("SUMMER10");

    shoppingCart.initiateCheckout();
  }
}
