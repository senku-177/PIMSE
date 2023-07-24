package com.pimse.repository;

import com.pimse.model.PurchaseInvoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseInvoiceRepository extends CrudRepository<PurchaseInvoice, Long> {

}