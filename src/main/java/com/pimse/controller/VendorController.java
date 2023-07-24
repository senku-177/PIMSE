package com.pimse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.pimse.model.Vendor;
import com.pimse.services.VendorService;

@RestController
public class VendorController {
	@Autowired
	private VendorService VendorService;

	@CrossOrigin(origins="*")
	@RequestMapping(value="/get-vendor",method=RequestMethod.GET,produces="application/json")
	public List<Vendor> getAllVendors() {
		return VendorService.getAllVendors();
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/add-vendor", method = RequestMethod.POST,
			consumes = "application/json")
	public void addVendor(@RequestBody Vendor VendorRecord) {
		VendorService.addVendor(VendorRecord);
	}
}