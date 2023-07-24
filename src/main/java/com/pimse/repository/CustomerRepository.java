package com.pimse.repository;

import com.pimse.model.Customer;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	public List<Customer> findByCustomerName(String customerName);

}

