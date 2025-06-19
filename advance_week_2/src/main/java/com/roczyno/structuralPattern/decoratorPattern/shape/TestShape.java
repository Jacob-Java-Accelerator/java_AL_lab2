package com.roczyno.structuralPattern.decoratorPattern.shape;

public class TestShape {

  public static void main(String[] args) {
    Circle circle = new Circle();

    // You can now set additional properties
    ColouredCircle circleExtended = new ColouredCircle(circle);
    circleExtended.setColor("Red");
    circleExtended.setName("My Red Circle");

    System.out.println(circleExtended.toString());
  }
}
