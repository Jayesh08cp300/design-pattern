package com.example.patterns.creational.convertor;

public class CustomerConverter extends Converter<CustomerDto, Customer> {

	public CustomerConverter() {
		super(CustomerConverter::convertToCustomer, CustomerConverter::convertToCustomerDto);
	}

	private static Customer convertToCustomer(CustomerDto customerDto) {
		return new Customer(customerDto.getCustomerId(), customerDto.getCustomerName(), customerDto.getCustomerLastName(),
				customerDto.isStatus());
	}

	private static CustomerDto convertToCustomerDto(Customer customer) {
		return new CustomerDto(customer.getCustomerId(), customer.getCustomerName(), customer.getCustomerLastName(), customer.isStatus());
	}

}
