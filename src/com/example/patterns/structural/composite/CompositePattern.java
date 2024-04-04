package com.example.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

interface Graphic {
	void draw(int area);
}

class Circle implements Graphic {

	@Override
	public void draw(int area) {
		System.out.println("Circle area = " + area);
	}
}

class Square implements Graphic {

	@Override
	public void draw(int area) {
		System.out.println("Square area = " + area);
	}
}

class GraphicGroup implements Graphic {
	private List<Graphic> graphics;

	public GraphicGroup() {
		graphics = new ArrayList<>();
	}

	public void addGraphic(Graphic graphic) {
		graphics.add(graphic);
	}

	@Override
	public void draw(int area) {
		graphics.parallelStream()
				.forEach(graphic -> graphic.draw(area));
	}
}

public class CompositePattern {
	public static void main(String[] args) {
		Circle circle1 = new Circle();
		Circle circle2 = new Circle();
		Square square = new Square();

		GraphicGroup group1 = new GraphicGroup();
		group1.addGraphic(circle1);
		group1.addGraphic(square);

		GraphicGroup group2 = new GraphicGroup();
		group2.addGraphic(circle2);
		group2.addGraphic(group1);

		group2.draw(20);
	}
}
