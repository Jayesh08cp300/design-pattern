package com.example.patterns.creational.convertor;

public class CustomerConverter extends Converter<CustomerDto, Customer> {

	public CustomerConverter() {
		super(CustomerConverter::convertToEntity, CustomerConverter::convertToDto);
	}

	private static Customer convertToEntity(CustomerDto customerDto) {
		return new Customer(customerDto.getCustomerId(), customerDto.getCustomerName(), customerDto.getCustomerLastName(),
				customerDto.isStatus());
	}

	private static CustomerDto convertToDto(Customer customer) {
		return new CustomerDto(customer.getCustomerId(), customer.getCustomerName(), customer.getCustomerLastName(), customer.isStatus());
	}

}
