package com.pimse.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Data
public class SalesDataMonthly {

	private String monthName;

	public SalesDataMonthly(String monthName, Double sales,Double salesWithoutTax) {
		this.monthName = monthName;
		this.sales = sales;
		this.salesWithoutTax=salesWithoutTax;
	}

	private Double sales;
	private Double salesWithoutTax;

}
