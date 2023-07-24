package com.pimse.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {

	private String productName;
	private String uomName;
	private String family;
	private String description;
	private String sku;
	private double sellingPrice;

}
