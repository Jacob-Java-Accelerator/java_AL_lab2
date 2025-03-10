package com.creationalPatterns.FactoryPattern.shapes;

public class Circle implements Shape {

  public Circle() {

  }

  @Override
  public void draw() {
    System.out.println("draw a cirle");
  }

}
