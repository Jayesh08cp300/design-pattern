package com.example.patterns.creational.prototype;

import java.util.Hashtable;

abstract class Shape implements Cloneable {
	private int id;
	private String type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	abstract protected void print();

	public Object clone() {
		Object cloneObject;
		try {
			cloneObject = super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
		return cloneObject;
	}
}

class Rectangle extends Shape {
	public Rectangle() {
		setType("Rectangle");
	}

	@Override
	protected void print() {
		System.out.println("Id = " + getId() + ", Type = " + getType());
	}
}

class Circle extends Shape {
	public Circle() {
		setType("Circle");
	}

	@Override
	protected void print() {
		System.out.println("Id = " + getId() + ", Type = " + getType());
	}
}

class ShapeCache {
	private static Hashtable<Integer, Shape> SHAPES = new Hashtable<>();

	static {
		Shape circle = new Circle();
		circle.setId(1);
		SHAPES.put(circle.getId(), circle);

		Shape rectangle = new Rectangle();
		rectangle.setId(2);
		SHAPES.put(rectangle.getId(), circle);
	}

	public static Shape getShape(int id) {
		return (Shape) SHAPES.get(id).clone();
	}

}

public class Prototype {

	public static void main(String[] args) {
		Shape shape = ShapeCache.getShape(1);
		shape.print();
		System.out.println(shape);
		Shape shape2 = ShapeCache.getShape(1);
		shape2.print();
		System.out.println(shape);
	}
}
