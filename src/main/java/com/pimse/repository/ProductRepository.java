package com.pimse.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pimse.model.Customer;
import com.pimse.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	public List<Product> findByProductName(String productName);
}
