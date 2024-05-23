package com.example.patterns.creational.builder;

public class BuilderFactory {
	public static void main(String[] args) {
		Student student = new Student.StudentBuilder().setId(1)
				.setName("Jayesh")
				.setAddress("Vadodara")
				.build();

		System.out.println(student);
	}
}
