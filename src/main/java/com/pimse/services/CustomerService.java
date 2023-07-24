package com.pimse.services;

import com.pimse.model.Customer;
import com.pimse.model.Product;
import com.pimse.repository.CustomerRepository;
import com.pimse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<>();
		customerRepository.findAll().forEach(customers::add);
		return customers;
	}

	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public void deleteCustomer (Customer customer) {
		customerRepository.delete(customer);
	}

	public List<Customer> searchCustomerByName (String name) {
		List<Customer> optionalCustomer = customerRepository.findByCustomerName(name);
		 if(optionalCustomer != null ) {
		 	return optionalCustomer;
		 }
		 return  null;
	}

	public void searchCustomerByIds (List<Long> Ids) {
		customerRepository.findAllById(Ids);
	}
}
