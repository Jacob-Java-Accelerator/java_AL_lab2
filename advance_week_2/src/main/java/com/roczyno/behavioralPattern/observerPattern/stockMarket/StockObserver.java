package com.roczyno.behavioralPattern.observerPattern.stockMarket;

public interface StockObserver {
	void update(String stockSymbol, float stockPrice);
}
