package com.roczyno.behavioralPattern.template;

public class OrderApp {
	public static void main(String[] args) {
		OrderProcessor domesticOrder = new DomesticOrder();
		domesticOrder.processOrder();

		System.out.println("---");

		OrderProcessor internationalOrder = new InternationalOrder();
		internationalOrder.processOrder();
	}
}

