package com.pimse.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.pimse.model.Product;
import com.pimse.model.ProductRequest;
import com.pimse.model.UOM;
import com.pimse.services.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService ProductService;

	@CrossOrigin(origins="*")
	@RequestMapping(value="/get-product",method=RequestMethod.GET,
			produces="application/json")
	public List<Product> getAllProducts() {
		return ProductService.getAllProducts();
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/add-product", method = RequestMethod.POST,consumes = "application/json")
	public void add(@RequestBody ProductRequest ProductRecord) {
		Product product=new Product();
		UOM uom=new UOM();
		product.setActive(true);
		product.setDescription(ProductRecord.getDescription());
		product.setFamily(ProductRecord.getFamily());
		product.setProductName(ProductRecord.getProductName());
		product.setSku(ProductRecord.getSku());
		product.setSellingPrice(ProductRecord.getSellingPrice());
		uom.setUomName(ProductRecord.getUomName());
		product.setUOM(uom);
		ProductService.addProduct(product);
	}
}