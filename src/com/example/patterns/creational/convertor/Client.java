package com.example.patterns.creational.convertor;

import java.util.ArrayList;
import java.util.List;

public class Client {
	/**
	 * Program entry point
	 *
	 * @param args command line args
	 */
	public static void main(String[] args) {

		Converter<CustomerDto, Customer> CustomerConverter = new CustomerConverter();

		CustomerDto customerDto = new CustomerDto("100", "Ramesh", "Fadatare", true);
		Customer Customer = CustomerConverter.toDestination(customerDto);

		System.out.println("Entity converted from DTO:" + Customer);

		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("100", "Ramesh1", "Fadatare", true));
		customers.add(new Customer("200", "Ramesh2", "Fadatare", true));
		customers.add(new Customer("300", "Ramesh3", "Fadatare", true));

		customers.forEach(System.out::println);

		customers.forEach((customer) -> System.out.println(customer.getCustomerId()));

		System.out.println("DTO entities converted from domain:");
		List<CustomerDto> customerDtos = CustomerConverter.toSources(customers);
		customerDtos.forEach(System.out::println);
		customerDtos.forEach((customer) -> System.out.println(customer.getCustomerId()));

	}
}