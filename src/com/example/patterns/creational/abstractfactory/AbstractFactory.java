package com.example.patterns.creational.abstractfactory;

import com.example.patterns.creational.abstractfactory.colour.Colour;
import com.example.patterns.creational.abstractfactory.shape.Shape;
import com.example.patterns.creational.abstractfactory.tool.Tool;

public interface AbstractFactory {
	Shape getShape(String shapeName);

	Colour getColour(String colourName);

	Tool getTool(String toolName);
}
