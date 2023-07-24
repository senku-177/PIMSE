package com.pimse.controller;

import java.util.ArrayList;
import java.util.List;

import com.pimse.model.AddRowRequest;
import com.pimse.model.PurchaseOrderItem;
import com.pimse.model.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.pimse.model.Inventory;
import com.pimse.model.Product;
import com.pimse.model.PurchaseInvoice;
import com.pimse.model.PurchaseInvoiceRequest;
import com.pimse.services.InventoryService;
import com.pimse.services.ProductService;
import com.pimse.services.PurchaseInvoiceService;
import com.pimse.services.VendorService;

@RestController
public class PurchaseInvoiceController {
	
	@Autowired
	private PurchaseInvoiceService purchaseService;

	@Autowired
	private ProductService productService;
	@Autowired
	private VendorService vendorService;
	@Autowired
	private InventoryService inventoryService;
	
	@RequestMapping(value="/get-purchaseInvoice",method=RequestMethod.GET,produces="application/json")
	public List<PurchaseInvoice> getAllPurchaseInvoices() {
		return purchaseService.getAllPurchaseInvoices();
	}

	@CrossOrigin(origins="*")
	@RequestMapping(value="/add-purchaseAddRow",method=RequestMethod.POST,produces="application/json" ,consumes="application/json")
	public String checkAddRow(@RequestBody AddRowRequest request) {
		List<Product> productList=productService.searchProductByName(request.getProductName());
		if(productList==null||productList.isEmpty()) {
			return "Product not Found";
		}
		return "true";
	}

	@CrossOrigin(origins="*")
	@RequestMapping(value = "/add-purchaseInvoice", method = RequestMethod.POST,
			consumes = "application/json")
	public String addPurchaseInvoice(@RequestBody PurchaseInvoiceRequest purchaseRecord) {
		List<PurchaseOrderItem> orderItemList=new ArrayList<PurchaseOrderItem>();
		PurchaseInvoice purchase=new PurchaseInvoice();
		purchase.setCreatedDate(purchaseRecord.getCreatedDate());
		List<Vendor> v=vendorService.searchVendorByName(purchaseRecord.getVendors().getVendorName());
		if(v==null||v.isEmpty()){
			return "false";
		}
		for(int i=0;i<purchaseRecord.getOrderItemList().size();i++) {
			PurchaseOrderItem item=new PurchaseOrderItem();
			Inventory inventory=new Inventory();
			List<Product> productList=productService.searchProductByName(purchaseRecord.getOrderItemList().get(i).getProductName());
				List<Inventory> inventoryList=inventoryService.searchByInventoryProductName(productList.get(0));
			if(inventoryList==null || inventoryList.isEmpty()) {
					inventory.setProduct(productList.get(0));
					inventory.setQuantity(purchaseRecord.getOrderItemList().get(i).getQuantity());
				inventoryService.addInventory(inventory);
				}
				else {
					inventoryList.get(0).setQuantity(inventoryList.get(0).getQuantity()+purchaseRecord.getOrderItemList().get(i).getQuantity());
					inventoryService.addInventory(inventoryList.get(0));
				}

				item.setProduct(productList.get(0));
				item.setPrice(purchaseRecord.getOrderItemList().get(i).getPrice());
				item.setQuantity(purchaseRecord.getOrderItemList().get(i).getQuantity());
				item.setTaxPercentage(purchaseRecord.getOrderItemList().get(i).getTaxPercentage());
				item.setCreatedDate(purchaseRecord.getCreatedDate());
				orderItemList.add(item);
		}
		purchase.setOrderItemList(orderItemList);
		purchase.setVendors(v.get(0));
		System.out.print(purchase);
		purchaseService.addPurchaseInvoice(purchase);
		return "true";

	}
	
}