package com.example.patterns.creational.abstractfactory;

import com.example.patterns.creational.abstractfactory.colour.Colour;
import com.example.patterns.creational.abstractfactory.shape.Shape;
import com.example.patterns.creational.abstractfactory.tool.Tool;

public class AbstractFactoryEx {
	public static void main(String[] args) {
		AbstractFactory colourFactory = Painter.getFactory("Colour");
		Colour colour = colourFactory.getColour("Red");
		colour.fill();

		AbstractFactory shapeFactory = Painter.getFactory("Shape");
		Shape shape = shapeFactory.getShape("Circle");
		shape.draw();

		AbstractFactory toolFactory = Painter.getFactory("Tool");
		Tool tool = toolFactory.getTool("Eraser");
		tool.pick();
	}
}
