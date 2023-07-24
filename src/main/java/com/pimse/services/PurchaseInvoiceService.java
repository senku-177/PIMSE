package com.pimse.services;

import com.pimse.model.PurchaseInvoice;
import com.pimse.repository.PurchaseInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseInvoiceService {
	@Autowired
	private PurchaseInvoiceRepository purchaseInvoiceRepository;

	public List<PurchaseInvoice> getAllPurchaseInvoices() {
		List<PurchaseInvoice> purchaseInvoices = new ArrayList<>();
		purchaseInvoiceRepository.findAll().forEach(purchaseInvoices::add);
		return purchaseInvoices;
	}


	public void addPurchaseInvoice(PurchaseInvoice purchaseInvoice) {
		purchaseInvoiceRepository.save(purchaseInvoice);
	}

	public void deletePurchaseInvoice (PurchaseInvoice purchaseInvoice) {
		purchaseInvoiceRepository.delete(purchaseInvoice);
	}

	public PurchaseInvoice searchPurchaseInvoiceById (Long Id) {
		Optional<PurchaseInvoice> optionalPurchaseInvoice = purchaseInvoiceRepository.findById(Id);
		if(optionalPurchaseInvoice.isPresent()) {
			return optionalPurchaseInvoice.get();
		}
		return  null;
	}


	public void searchPurchaseInvoiceByIds (List<Long> Ids) {
		purchaseInvoiceRepository.findAllById(Ids);
	}

}
