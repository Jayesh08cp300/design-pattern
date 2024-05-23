package com.example.patterns.creational.objectpool;

import java.util.ArrayList;
import java.util.List;

// Object to be pooled
class PooledObject {
	// Some state or functionality
	private int id;

	public PooledObject(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}

// Object pool class
class ObjectPool {
	private List<PooledObject> pool;
	private int maxSize;

	public ObjectPool(int maxSize) {
		this.maxSize = maxSize;
		pool = new ArrayList<>();
	}

	public synchronized PooledObject getObject() {
		if (pool.isEmpty()) {
			if (pool.size() < maxSize) {
				pool.add(new PooledObject(pool.size() + 1));
			} else {
				throw new RuntimeException("Max size reached");
			}
		}
		return pool.remove(0);
	}

	public synchronized void releaseObject(PooledObject obj) {
		pool.add(obj);
	}
}

public class ExampleTwo {
	public static void main(String[] args) {
		// Create an object pool with a maximum size of 3
		ObjectPool objectPool = new ObjectPool(3);

		// Get objects from the pool
		PooledObject obj1 = objectPool.getObject();
		PooledObject obj2 = objectPool.getObject();
		PooledObject obj3 = objectPool.getObject();

		System.out.println("Object 1 ID: " + obj1.getId() + "Object = " + obj1.toString());
		System.out.println("Object 2 ID: " + obj2.getId() + "Object = " + obj2.toString());
		System.out.println("Object 3 ID: " + obj3.getId() + "Object = " + obj3.toString());

		// Release objects back to the pool
		objectPool.releaseObject(obj1);
		objectPool.releaseObject(obj2);
		objectPool.releaseObject(obj3);

		// Get more objects from the pool
		PooledObject obj4 = objectPool.getObject();
		PooledObject obj5 = objectPool.getObject();

		System.out.println("Object 4 ID: " + obj4.getId() + "Object = " + obj4.toString());
		System.out.println("Object 5 ID: " + obj5.getId() + "Object = " + obj5.toString());

		PooledObject obj6 = objectPool.getObject();
		PooledObject obj7 = objectPool.getObject();
		PooledObject obj8 = objectPool.getObject();

		System.out.println("Object 6 ID: " + obj4.getId() + "Object = " + obj6.toString());
		System.out.println("Object 7 ID: " + obj5.getId() + "Object = " + obj7.toString());
		System.out.println("Object 8 ID: " + obj5.getId() + "Object = " + obj8.toString());
	}
}
