package com.pimse.repository;

import com.pimse.model.SalesDataMonthly;
import com.pimse.model.SalesInvoice;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesInvoiceRepository extends CrudRepository<SalesInvoice, Long> {
	
	@Query(value = "SELECT new com.pimse.model.SalesDataMonthly (CONCAT(MONTHNAME(created_date),"+"\t"+ "year(created_date)) as monthName, \n" +
			"SUM((price*quantity*(1+ taxPercentage/100))) AS sales, \n" +
			"SUM(price*quantity) AS salesWithoutTax) FROM SalesOrderItem \n" +
			"GROUP BY MONTH(createdDate) ORDER BY MONTH(createdDate)")
	ArrayList<SalesDataMonthly> countTotalCommentsByMonthNative();
}