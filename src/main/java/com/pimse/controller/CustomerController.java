package com.pimse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pimse.model.Customer;
import com.pimse.services.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService CustomerService;

	@CrossOrigin(origins="*")
	@RequestMapping(value="/get-customer",method=RequestMethod.GET,produces="application/json")
	public List<Customer> getAllCustomers() {
		return CustomerService.getAllCustomers();
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/add-customer", method = RequestMethod.POST,
			consumes = "application/json")
	public void addCustomer(@RequestBody Customer CustomerRecord) {
		CustomerService.addCustomer(CustomerRecord);
	}
}
