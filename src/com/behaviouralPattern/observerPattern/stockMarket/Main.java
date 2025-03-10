package com.behaviouralPattern.observerPattern.stockMarket;

public class Main {
  public static void main(String[] args) {
    StockExchange stockExchange = new StockExchange();

    Trader traderJoe = new Trader("Joe");
    Trader traderCharles = new Trader("Charles");

    stockExchange.registerObserver(traderJoe);
    stockExchange.registerObserver(traderCharles);

    stockExchange.setStockPrice("AAPL", 150.50f);
    stockExchange.setStockPrice("GOOGL", 2800.75f);
  }
}
