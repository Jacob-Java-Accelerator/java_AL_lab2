package com.structuralPattern.decoratorPattern.shape;

public class ColouredCircle extends CircleDecorator {
  private String color;
  private String name;

  public ColouredCircle(Circle circle) {
    super(circle);
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "ColouredCircle [circle=" + circle + ", color=" + color + ", name=" + name + "]";
  }

}
