package com.example.patterns.creational.abstractfactory.tool;

import com.example.patterns.creational.abstractfactory.AbstractFactory;
import com.example.patterns.creational.abstractfactory.colour.Colour;
import com.example.patterns.creational.abstractfactory.shape.Shape;

public class ToolFactory implements AbstractFactory {
	@Override
	public Shape getShape(String shapeName) {
		return null;
	}

	@Override
	public Colour getColour(String colourName) {
		return null;
	}

	@Override
	public Tool getTool(String toolName) {
		if ("Eraser".equalsIgnoreCase(toolName)) {
			return new Eraser();
		} else if ("Magnifier".equalsIgnoreCase(toolName)) {
			return new Magnifier();
		}
		return null;
	}
}
