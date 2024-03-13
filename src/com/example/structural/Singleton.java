package com.example.structural;

class LazyInitialization {
	private static LazyInitialization lazyInitialization;

	private LazyInitialization() {
		System.out.println("LazyInitialization constructor called");
	}

	public static synchronized LazyInitialization getLazyInitialization() {
		if (null == lazyInitialization) {
			return new LazyInitialization();
		} else {
			return lazyInitialization;
		}
	}

	public void print() {
		System.out.println("Print method called");
	}

}

class EagerInitialization {
	private static EagerInitialization eagerInitialization = new EagerInitialization();

	private EagerInitialization() {
		System.out.println("EagerInitialization constructor called");
	}

	public static EagerInitialization getEagerInitialization() {
		return eagerInitialization;
	}

	public void print() {
		System.out.println("Print method called");
	}

}

public class Singleton {
	public static void main(String[] args) {
		LazyInitialization lazyInitialization = LazyInitialization.getLazyInitialization();
		lazyInitialization.print();

		EagerInitialization eagerInitialization = EagerInitialization.getEagerInitialization();
		eagerInitialization.print();
	}
}
