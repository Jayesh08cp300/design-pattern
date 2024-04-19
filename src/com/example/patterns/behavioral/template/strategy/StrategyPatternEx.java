package com.example.patterns.behavioral.template.strategy;

interface PaymentStrategy {
	void pay(double amount);
}

class CreditCardStrategy implements PaymentStrategy {
	private String creditCardNumber;

	public CreditCardStrategy(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	@Override
	public void pay(double amount) {
		System.out.println("Amount Paid by CreditCard -> " + amount);
	}
}

class DebitCardStrategy implements PaymentStrategy {
	private String debitCardNumber;

	public DebitCardStrategy(String debitCardNumber) {
		this.debitCardNumber = debitCardNumber;
	}

	@Override
	public void pay(double amount) {
		System.out.println("Amount Paid DebitCard -> " + amount);
	}
}

class ShoppingCart {
	private PaymentStrategy paymentStrategy;

	public ShoppingCart(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}

	public void checkOut(double amount) {
		paymentStrategy.pay(amount);
	}
}

public class StrategyPatternEx {
	public static void main(String[] args) {
		ShoppingCart shoppingCart1 = new ShoppingCart(new DebitCardStrategy("007"));
		shoppingCart1.checkOut(1000);

		ShoppingCart shoppingCart2 = new ShoppingCart(new DebitCardStrategy("008"));
		shoppingCart2.checkOut(10000);
	}
}
