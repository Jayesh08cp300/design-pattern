package com.example.patterns.creational.abstractfactory.tool;

public class Eraser implements Tool {
	@Override
	public void pick() {
		System.out.println("Eraser picked.");
	}
}
