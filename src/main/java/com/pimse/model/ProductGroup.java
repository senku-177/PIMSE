package com.pimse.model;

import java.util.List;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductGroup {

	private List<Product> productGroups;

}
