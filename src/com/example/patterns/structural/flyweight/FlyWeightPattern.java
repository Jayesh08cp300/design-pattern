package com.example.patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

interface Shape {
	void draw(int x, int y, int width, int height);
}

class Circle implements Shape {

	private String colour;

	public Circle(String colour) {
		this.colour = colour;
	}

	@Override
	public void draw(int x, int y, int width, int height) {
		System.out.println(
				this + " -> Drawing Circle with Color: " + this.colour + ", X: " + x + ", Y: " + y + ", Width: " + width + ", Height: "
						+ height);
	}
}

class ShapeFactory {
	private static Map<String, Shape> shapeMap = new HashMap<>();

	public static synchronized Shape getCircle(String colour) {
		Shape shape = shapeMap.get(colour);
		if (null == shape) {
			shapeMap.put(colour, new Circle(colour));
		}
		return shapeMap.get(colour);
	}

	public static int getShapeMapSize() {
		return shapeMap.size();
	}
}

public class FlyWeightPattern {

	private static final String[] colors = { "Red", "Blue", "Yellow", "Green" };

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
			circle.draw(getRandomX(), getRandomY(), 50, 50);
		}

		System.out.println("shapeMap size = " + ShapeFactory.getShapeMapSize());
	}

	private static String getRandomColor() {
		return colors[(int) (Math.random() * colors.length)];
	}

	private static int getRandomX() {
		return (int) (Math.random() * 100);
	}

	private static int getRandomY() {
		return (int) (Math.random() * 100);
	}

}
