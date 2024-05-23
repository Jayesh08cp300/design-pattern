package com.example.patterns.creational.abstractfactory.shape;

import com.example.patterns.creational.abstractfactory.AbstractFactory;
import com.example.patterns.creational.abstractfactory.colour.Colour;
import com.example.patterns.creational.abstractfactory.tool.Tool;

public class ShapeFactory implements AbstractFactory {
	@Override
	public Shape getShape(String shapeName) {
		if ("Circle".equalsIgnoreCase(shapeName)) {
			return new Circle();
		} else if ("Square".equalsIgnoreCase(shapeName)) {
			return new Square();
		} else if ("Triangle".equalsIgnoreCase(shapeName)) {
			return new Triangle();
		} else if ("Rectangle".equalsIgnoreCase(shapeName)) {
			return new Rectangle();
		}
		return null;
	}

	@Override
	public Colour getColour(String colourName) {
		return null;
	}

	@Override
	public Tool getTool(String toolName) {
		return null;
	}
}
