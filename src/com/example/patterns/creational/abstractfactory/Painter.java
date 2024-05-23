package com.example.patterns.creational.abstractfactory;

import com.example.patterns.creational.abstractfactory.colour.ColourFactory;
import com.example.patterns.creational.abstractfactory.shape.ShapeFactory;
import com.example.patterns.creational.abstractfactory.tool.ToolFactory;

public class Painter {
	public static AbstractFactory getFactory(String name) {
		if ("Colour".equalsIgnoreCase(name)) {
			return new ColourFactory();
		} else if ("Shape".equalsIgnoreCase(name)) {
			return new ShapeFactory();
		} else if ("Tool".equalsIgnoreCase(name)) {
			return new ToolFactory();
		}
		return null;
	}
}
