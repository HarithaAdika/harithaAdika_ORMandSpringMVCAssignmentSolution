package com.greatlearning.customerManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.customerManagement.model.Customer;
import com.greatlearning.customerManagement.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// add mapping for "/list"

	@RequestMapping("/list")
	public String getCustomersList(Model theModel) {

		System.out.println("Get Request recieved to retrieve the customers list");
		// get Customer details from db
		List<Customer> theCustomers = customerService.findAllCustomers();

		// this adds to the spring model
		theModel.addAttribute("Customers", theCustomers);

		return "customersList";
	}

	@RequestMapping("/customerFormForAdd")
	public String showFormForAdd(Model theModel) {
		System.out.println("Displaying Form to Add new customer");
		// this is used to create model attribute to bind form data
		Customer theCustomer = new Customer();

		theModel.addAttribute("Customer", theCustomer);

		return "saveNewCustomerForm";
	}

	@RequestMapping("/customerFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model theModel) {
		System.out.println("Displaying Form to update existing customer");
		// get the Customers from the service
		Customer theCustomer = customerService.findByCustomerId(id);

		// set new Customer as a model attribute to pre-populate the form
		theModel.addAttribute("Customer", theCustomer);

		// send to the existing form to update
		return "saveNewCustomerForm";
	}

	@PostMapping("/save")
	public String saveBook(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {

		System.out.println("Saving the Customer:" + id);
		Customer theCustomer;
		if (id != 0) {
			theCustomer = customerService.findByCustomerId(id);
			theCustomer.setFirstName(firstName);
			theCustomer.setLastName(lastName);
			theCustomer.setEmail(email);

		} else
			theCustomer = new Customer(firstName, lastName, email);
		// save the Customer
		customerService.saveCustomer(theCustomer);

		// use a redirect to prevent duplicate submissions
		return "redirect:/customers/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("customerId") int id) {

		// delete the Customer By Id
		customerService.deleteByCustomerId(id);
		System.out.println("Deleting Customer with Id:" + id);

		return "redirect:/customers/list";

	}

}
