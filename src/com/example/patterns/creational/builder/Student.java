package com.example.patterns.creational.builder;

public class Student {

	private int id;
	private String name;
	private String address;

	public Student(StudentBuilder studentBuilder) {
		this.id = studentBuilder.id;
		this.name = studentBuilder.name;
		this.address = studentBuilder.address;
	}

	@Override
	public String toString() {
		return "Student{" + "id=" + id + ", name='" + name + '\'' + ", address='" + address + '\'' + '}';
	}

	public static class StudentBuilder {
		private int id;
		private String name;
		private String address;

		public StudentBuilder setId(int id) {
			this.id = id;
			return this;
		}

		public StudentBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public StudentBuilder setAddress(String address) {
			this.address = address;
			return this;
		}

		public Student build() {
			return new Student(this);
		}
	}
}
