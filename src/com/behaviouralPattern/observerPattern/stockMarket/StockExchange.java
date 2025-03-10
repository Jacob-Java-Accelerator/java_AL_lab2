package com.behaviouralPattern.observerPattern.stockMarket;

import java.util.ArrayList;
import java.util.List;

class StockExchange implements StockMarket {
  private List<StockObserver> observers;
  private String stockSymbol;
  private float stockPrice;

  public StockExchange() {
    observers = new ArrayList<>();
  }

  public void setStockPrice(String stockSymbol, float stockPrice) {
    this.stockSymbol = stockSymbol;
    this.stockPrice = stockPrice;
    notifyObservers();
  }

  @Override
  public void registerObserver(StockObserver o) {
    observers.add(o);
  }

  @Override
  public void removeObserver(StockObserver o) {
    observers.remove(o);
  }

  @Override
  public void notifyObservers() {
    for (StockObserver observer : observers) {
      observer.update(stockSymbol, stockPrice);
    }
  }
}
