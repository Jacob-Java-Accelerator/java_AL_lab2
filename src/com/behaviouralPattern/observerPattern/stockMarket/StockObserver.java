package com.behaviouralPattern.observerPattern.stockMarket;

public interface StockObserver {
  void update(String stockSymbol, float stockPrice);

}
