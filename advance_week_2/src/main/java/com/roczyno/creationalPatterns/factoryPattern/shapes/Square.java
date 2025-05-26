package com.roczyno.creationalPatterns.factoryPattern.shapes;

public class Square implements Shape {
	public Square() {
	}

	@Override
	public void draw() {
		System.out.println("draw a square");
	}

}
