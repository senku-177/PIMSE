package com.pimse.controller;

import java.util.ArrayList;
import java.util.List;

import com.pimse.model.InventoryRecord;
import com.pimse.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pimse.model.SalesDataMonthly;
import com.pimse.repository.SalesInvoiceRepository;
import com.pimse.services.SalesInvoiceService;

@RestController
public class
DashboardController {

	@Autowired
	SalesInvoiceService salesInvoiceService;
	
	@Autowired
	SalesInvoiceRepository salesInvoiceRepository;
	@Autowired
	InventoryRepository inventoryRepository;
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/dashboard",method=RequestMethod.GET,produces="application/json")
	public void run () {
	}

	@CrossOrigin(origins="*")
	@RequestMapping(value="/dashboard/sales-record",method=RequestMethod.GET,produces="application/json")
	public List<SalesDataMonthly> getAllSales() {
		return salesInvoiceRepository.countTotalCommentsByMonthNative();
	}

	@CrossOrigin(origins="*")
	@RequestMapping(value="/dashboard/inventory-record",method=RequestMethod.GET,produces="application/json")
	public List<InventoryRecord> getAllProduct() {
		return inventoryRepository.showInventoryProducts();
	}
}
