package com.pimse.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name="Product")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	private String productName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private UOM UOM;
	private String family;
	private String description;
	private boolean isActive;
	private String sku;
	private double sellingPrice;
	
	@Column(name="createdDate", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private String createdDate=new Date().toString();
	
	@Column(name="updated_Date", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private String updated_date=new Date().toString();
}