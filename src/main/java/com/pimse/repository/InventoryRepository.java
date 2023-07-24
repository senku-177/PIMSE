package com.pimse.repository;

import java.util.ArrayList;
import java.util.List;

import com.pimse.model.InventoryRecord;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pimse.model.Inventory;
import com.pimse.model.Product;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory,Long>{
	public List<Inventory> findByProduct(Product product);

	@Query(value = "SELECT new com.pimse.model.InventoryRecord\n" +
			" (product.productName as productName,quantity as quantity,product.UOM.uomName as uomName)\n" +
			" FROM Inventory")
	List<InventoryRecord> showInventoryProducts();
}