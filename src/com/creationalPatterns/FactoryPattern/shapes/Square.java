package com.creationalPatterns.FactoryPattern.shapes;

public class Square implements Shape {
  public Square() {
  }

  @Override
  public void draw() {
    System.out.println("draw a square");
  }

}
