package com.example.patterns.behavioral.state;

interface Operation {
	void perform();
}

class Colour implements Operation {

	@Override
	public void perform() {
		System.out.println("Colour the Object");
	}
}

class Erase implements Operation {

	@Override
	public void perform() {
		System.out.println("Erase the Object");
	}
}

class Select implements Operation {

	@Override
	public void perform() {
		System.out.println("Select the Object");
	}
}

class Draw implements Operation {

	@Override
	public void perform() {
		System.out.println("Draw the Object");
	}
}

class Paint implements Operation {
	private Operation operation;

	public Paint(Operation operation) {
		this.operation = operation;
	}

	@Override
	public void perform() {
		operation.perform();
	}
}

public class StatePatternEx {
	public static void main(String[] args) {
		Paint paint = new Paint(new Select());
		paint.perform();
		paint = new Paint(new Draw());
		paint.perform();
		paint = new Paint(new Colour());
		paint.perform();
		paint = new Paint(new Erase());
		paint.perform();
	}
}
