package com.structuralPattern.facadePattern.shoppingCart;

import java.util.HashMap;
import java.util.Map;

class DiscountService {
  private Map<String, Discount> discounts = new HashMap<>();

  public void applyDiscount(String discountCode, ShoppingCart cart) {
    Discount discount = discounts.get(discountCode);
    if (discount != null) {
      cart.setDiscount(discount.getAmount());
    }
  }
}

public class ShoppingCart {
  private int discount = 0;
  private Map<String, Integer> items = new HashMap<>();

  public void addItem(String itemId, int quantity) {
    items.put(itemId, items.getOrDefault(itemId, 0) + quantity);
  }

  public void setDiscount(int discount) {
    this.discount = discount;
  }

  public double calculateTotal(Map<String, Product> products) {
    double total = 0.0;
    for (Map.Entry<String, Integer> entry : items.entrySet()) {
      String itemId = entry.getKey();
      int quantity = entry.getValue();
      Product product = products.get(itemId);
      if (product != null) {
        total += product.getPrice() * quantity;
      }
    }
    return total - discount;
  }
}
