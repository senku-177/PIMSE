package com.pimse.services;

import com.pimse.model.SalesInvoice;
import com.pimse.model.Product;
import com.pimse.repository.SalesInvoiceRepository;
import com.pimse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SalesInvoiceService {
	@Autowired
	private SalesInvoiceRepository salesInvoiceRepository;

	public List<SalesInvoice> getAllSalesInvoices() {
		List<SalesInvoice> salesInvoices = new ArrayList<>();
		salesInvoiceRepository.findAll().forEach(salesInvoices::add);
		return salesInvoices;
	}


	public void addSalesInvoice(SalesInvoice salesInvoice) {
		salesInvoiceRepository.save(salesInvoice);
	}

	public void deleteSalesInvoice (SalesInvoice salesInvoice) {
		salesInvoiceRepository.delete(salesInvoice);
	}

	public SalesInvoice searchSalesInvoiceById (Long Id) {
		Optional<SalesInvoice> optionalSalesInvoice = salesInvoiceRepository.findById(Id);
		if(optionalSalesInvoice.isPresent()) {
			return optionalSalesInvoice.get();
		}
		return  null;
	}


	public void searchSalesInvoiceByIds (List<Long> Ids) {
		salesInvoiceRepository.findAllById(Ids);
	}

}
