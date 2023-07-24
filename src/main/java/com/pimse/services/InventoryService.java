package com.pimse.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pimse.model.Customer;
import com.pimse.model.Inventory;
import com.pimse.model.Product;
import com.pimse.repository.CustomerRepository;
import com.pimse.repository.InventoryRepository;

@Service
public class InventoryService {
	@Autowired
	private InventoryRepository inventoryRepository;
	
	public List<Inventory> getAllInventoryItems(){
		List<Inventory> inventory=new ArrayList<>();
		inventoryRepository.findAll().forEach(inventory::add);
		return inventory;
	}
	
	public void addInventory(Inventory inventory) {
		inventoryRepository.save(inventory);
	}
	
	public void deleteInventory(Inventory inventory) {
		inventoryRepository.delete(inventory);
	}
	
	public void searchInventoryById(long id) {
		inventoryRepository.findById(id);
	}
	public List<Inventory> searchByInventoryProductName (Product product) {
		List<Inventory> optionalProduct = inventoryRepository.findByProduct(product);
		 	return optionalProduct;
	}
	
}