package com.pimse.model;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class OrderItemRequest {
	
	private String productName;
	private Double quantity;
	private Double price;
	private Double amount;
	private Double taxPercentage;
}
