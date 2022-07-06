package com.greatlearning.customerManagement.service;

import java.util.List;

import com.greatlearning.customerManagement.model.Customer;

public interface CustomerService {
	public List<Customer> findAllCustomers();

	public Customer findByCustomerId(int id);

	public void saveCustomer(Customer customer);

	public void deleteByCustomerId(int id);

}
