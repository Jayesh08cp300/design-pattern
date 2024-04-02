package com.example.patterns.structural.facade;

// Subsystem 1
class Inventory {
	public boolean isAvailable(String product) {
		FacadePattern.sleep();
		// Check warehouse database for product availability.
		System.out.println("checking product availability");
		return true;
	}
}

// Subsystem 2
class Payment {
	public boolean processPayment(String orderID) {
		FacadePattern.sleep();
		// Process payment.
		System.out.println("processing payment");
		return true;
	}
}

// Subsystem 3
class Shipping {
	public void shipProduct(String product) {
		FacadePattern.sleep();
		// Ship the product.
		System.out.println("shipping order");
	}
}

// Facade
class OrderServiceFacade {
	private Inventory inventory;
	private Payment payment;
	private Shipping shipping;

	public OrderServiceFacade() {
		inventory = new Inventory();
		payment = new Payment();
		shipping = new Shipping();
	}

	public boolean placeOrder(String productID) {
		if (!inventory.isAvailable(productID)) {
			return false;
		} else if (!payment.processPayment(productID)) {
			return false;
		}
		shipping.shipProduct(productID);
		FacadePattern.sleep();
		return true;
	}
}

// Client code
public class FacadePattern {

	public static void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		System.out.println("Order placed successfully: " + new OrderServiceFacade().placeOrder("1234"));
	}
}

