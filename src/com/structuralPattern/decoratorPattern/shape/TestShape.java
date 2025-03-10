package com.structuralPattern.decoratorPattern.shape;

public class TestShape {

  public static void main(String[] args) {
    Circle circle = new Circle();
    Circle circleExtended = new ColouredCircle(circle);
    System.out.println(circleExtended.toString());
  }
}
