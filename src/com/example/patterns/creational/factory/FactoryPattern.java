package com.example.patterns.creational.factory;

enum DrawId {
	RECTANGLE, CIRCLE;
}

interface Draw {
	void draw();
}

class RectangleDraw implements Draw {

	@Override
	public void draw() {
		System.out.println("Rectangle Draw");
	}
}

class CircleDraw implements Draw {

	@Override
	public void draw() {
		System.out.println("Circle Draw");
	}
}

abstract class DrawFactory {
	public static Draw getDraw(DrawId id) {
		if (null == id) {
			return null;
		} else if (DrawId.RECTANGLE.equals(id)) {
			return new RectangleDraw();
		} else if (DrawId.CIRCLE.equals(id)) {
			return new CircleDraw();
		}
		return null;
	}
}

public class FactoryPattern {
	public static void main(String[] args) {
		Draw draw = DrawFactory.getDraw(DrawId.RECTANGLE);
		draw.draw();

		draw = DrawFactory.getDraw(DrawId.CIRCLE);
		draw.draw();
	}
}
