package com.example.patterns.behavioral.template;

abstract class Game {

	public final void playGame() {
		initializeGame();
		startGame();
		endGame();
	}

	protected abstract void endGame();

	protected abstract void startGame();

	private void initializeGame() {
		System.out.println("Initialing game.");
	}
}

class Football extends Game {

	@Override
	protected void endGame() {
		System.out.println("Ending football game.");
	}

	@Override
	protected void startGame() {
		System.out.println("Starting football game.");
	}
}

public class TemplatePatternEx {
	public static void main(String[] args) {
		Game game = new Football();
		game.playGame();
	}
}