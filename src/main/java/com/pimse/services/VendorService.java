package com.pimse.services;

import com.pimse.model.Vendor;
import com.pimse.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VendorService {
	@Autowired
	private VendorRepository vendorRepository;

	public List<Vendor> getAllVendors() {
		List<Vendor> vendors = new ArrayList<>();
		vendorRepository.findAll().forEach(vendors::add);
		return vendors;
	}


	public void addVendor(Vendor vendor) {
		vendorRepository.save(vendor);
	}

	public void deleteVendor (Vendor vendor) {
		vendorRepository.delete(vendor);
	}

	public Vendor searchVendorById (Long Id) {
		Optional<Vendor> optionalVendor = vendorRepository.findById(Id);
		if(optionalVendor.isPresent()) {
			return optionalVendor.get();
		}
		return  null;
	}
	
	public List<Vendor> searchVendorByName (String name) {
		List<Vendor> optionalVendor = vendorRepository.findByVendorName(name);
		if(optionalVendor!=null) {
			return optionalVendor;
		}
		return  null;
	}


	public void searchVendorByIds (List<Long> Ids) {
		vendorRepository.findAllById(Ids);
	}

}
