package com.behaviouralPattern.observerPattern.stockMarket;

public interface StockMarket {
  void registerObserver(StockObserver o);

  void removeObserver(StockObserver o);

  void notifyObservers();
}
