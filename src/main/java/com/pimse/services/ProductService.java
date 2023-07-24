
package com.pimse.services;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import com.pimse.model.Product;
import com.pimse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		productRepository.findAll().forEach(products::add);
		return products;
	}


	public void addProduct(Product product) {
		productRepository.save(product);
	}

	public void deleteProduct (Product product) {
		productRepository.delete(product);
	}

	public Product searchProductById (Long Id) {
		Optional<Product> optionalProduct = productRepository.findById(Id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		return  null;
	}

	public List<Product> searchProductByName(String name) {
		List<Product> optionalProduct = productRepository.findByProductName(name);
		if(optionalProduct!=null) {
			return optionalProduct;
		}
		return  null;
	}

	public void searchProductByIds (List<Long> Ids) {
		productRepository.findAllById(Ids);
	}

}
