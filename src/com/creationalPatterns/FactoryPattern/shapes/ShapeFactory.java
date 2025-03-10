package com.creationalPatterns.FactoryPattern.shapes;

public class ShapeFactory {
  public static Shape createShape(String shapeType) {
    if (shapeType.equalsIgnoreCase("circle")) {
      return new Circle();
    } else if (shapeType.equalsIgnoreCase("square")) {
      return new Square();
    } else {
      throw new IllegalArgumentException("Invalid shape type: " + shapeType);
    }
  }
}
