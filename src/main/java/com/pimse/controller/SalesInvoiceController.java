package com.pimse.controller;

import java.util.ArrayList;
import java.util.List;

import com.pimse.model.AddRowRequest;
import com.pimse.model.Inventory;
import com.pimse.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.pimse.model.Customer;
import com.pimse.model.SalesOrderItem;
import com.pimse.model.Product;
import com.pimse.model.SalesInvoice;
import com.pimse.model.SalesInvoiceRequest;
import com.pimse.services.CustomerService;
import com.pimse.services.ProductService;
import com.pimse.services.SalesInvoiceService;

@RestController
public class SalesInvoiceController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private SalesInvoiceService salesService;
	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private ProductService productService;

	@CrossOrigin(origins="*")
	@RequestMapping(value = "/get-salesInvoice", method = RequestMethod.GET,
			consumes = "application/json", produces="application/json")
	public List<SalesInvoice> getSalesInvoice(){
		return salesService.getAllSalesInvoices();
	}

	@CrossOrigin(origins="*")
	@RequestMapping(value = "/get-addRow", method = RequestMethod.POST,
			consumes = "application/json", produces="application/json")
	public String getAddRow(@RequestBody AddRowRequest newRow) {
		double x;
		List<Product> productList = productService.searchProductByName(newRow.getProductName());
		if (productList == null || productList.isEmpty()) {
			return "Product not Found";
		}
		List<Inventory> inventoryList = inventoryService.searchByInventoryProductName(productList.get(0));
		if (inventoryList == null || inventoryList.isEmpty()) {
			return "Product not available in Inventory";
		} else {
			x = inventoryList.get(0).getQuantity() - newRow.getQuantity();
			if (x < 0) {
				return "Desired quantity is more than available quantity";
			}
			return String.valueOf(productList.get(0).getSellingPrice());
		}
	}

	@CrossOrigin(origins="*")
	@RequestMapping(value = "/add-salesInvoice", method = RequestMethod.POST,
			consumes = "application/json", produces="application/json")
	public String addSalesInvoice(@RequestBody SalesInvoiceRequest salesRecord) {
		System.out.println(salesRecord.toString());
		List<SalesOrderItem> orderItemList=new ArrayList<>();
		SalesInvoice sales=new SalesInvoice();
		double x;
		List<Customer> c=customerService.searchCustomerByName(salesRecord.getCustomer().getCustomerName());
		if(c==null||c.isEmpty()){
			return "Customer not Found.";
		}
		else{
			sales.setCustomer(c.get(0));
		}
		for(int i=0;i<salesRecord.getOrderItemList().size();i++) {
			SalesOrderItem item=new SalesOrderItem();
			List<Product> productList=productService.searchProductByName(salesRecord.getOrderItemList().get(i).getProductName());
			List<Inventory> inventoryList=inventoryService.searchByInventoryProductName(productList.get(0));
			x=inventoryList.get(0).getQuantity()-salesRecord.getOrderItemList().get(i).getQuantity();
			inventoryList.get(0).setQuantity(x);
			item.setProduct(productService.searchProductByName(salesRecord.getOrderItemList().get(i).getProductName()).get(0));
			item.setPrice(salesRecord.getOrderItemList().get(i).getPrice());
			item.setQuantity(salesRecord.getOrderItemList().get(i).getQuantity());
			item.setTaxPercentage(salesRecord.getOrderItemList().get(i).getTaxPercentage());
			item.setCreatedDate(salesRecord.getCreatedDate());
			orderItemList.add(item);
			inventoryService.addInventory(inventoryList.get(0));
		}
		sales.setSalesOrderItemList(orderItemList);
		salesService.addSalesInvoice(sales);
		return "true";
	}
}