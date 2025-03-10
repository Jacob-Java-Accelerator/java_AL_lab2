package com.behaviouralPattern.observerPattern.stockMarket;

public class Trader implements StockObserver {
  private String brokerName;

  public Trader(String brokerName) {
    this.brokerName = brokerName;
  }

  @Override
  public void update(String stockSymbol, float stockPrice) {
    System.out.println("Broker " + brokerName + " notified. Stock: " + stockSymbol + " is now " + stockPrice);
  }
}
