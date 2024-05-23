package com.example.patterns.creational.abstractfactory.colour;

import com.example.patterns.creational.abstractfactory.AbstractFactory;
import com.example.patterns.creational.abstractfactory.shape.Shape;
import com.example.patterns.creational.abstractfactory.tool.Tool;

public class ColourFactory implements AbstractFactory {
	@Override
	public Shape getShape(String shapeName) {
		return null;
	}

	@Override
	public Colour getColour(String colourName) {
		if ("Red".equalsIgnoreCase(colourName)) {
			return new Red();
		} else if ("Blue".equalsIgnoreCase(colourName)) {
			return new Blue();
		} else if ("Green".equalsIgnoreCase(colourName)) {
			return new Green();
		}
		return null;
	}

	@Override
	public Tool getTool(String toolName) {
		return null;
	}
}
