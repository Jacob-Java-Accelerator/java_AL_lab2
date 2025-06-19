package com.roczyno.creationalPatterns.factoryPattern.shapes;


public class TestFactory {

	public static void main(String[] args) {
		Shape circle = ShapeFactory.createShape("circle");
		circle.draw();



	}
}
