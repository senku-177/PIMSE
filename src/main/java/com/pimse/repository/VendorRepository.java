package com.pimse.repository;

import com.pimse.model.Customer;
import com.pimse.model.Vendor;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends CrudRepository<Vendor, Long> {
	
	public List<Vendor> findByVendorName(String vendorName);
}

