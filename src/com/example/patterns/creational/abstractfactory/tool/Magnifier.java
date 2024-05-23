package com.example.patterns.creational.abstractfactory.tool;

public class Magnifier implements Tool {
	@Override
	public void pick() {
		System.out.println("Magnifier picked.");
	}
}
