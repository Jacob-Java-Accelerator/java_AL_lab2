package com.structuralPattern.decoratorPattern.shape;

public class CircleDecorator extends Circle {
  protected Circle circle;

  public CircleDecorator(Circle circle) {
    this.circle = circle;
  }

  @Override
  public void getArea() {
    circle.getArea();
  }

}
