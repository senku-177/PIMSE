package com.pimse.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity(name="Inventory")
@Getter
@Setter
public class Inventory {
	@Id
	@GeneratedValue( strategy= GenerationType.AUTO )
	private long inventory_id;
	
	@OneToOne
	private Product product;
	private double quantity;
}
