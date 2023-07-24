package com.pimse.services;

import com.pimse.model.UOM;
import com.pimse.model.Product;
import com.pimse.repository.UOMRepository;
import com.pimse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UomService {
	@Autowired
	private UOMRepository UOMRepository;

	public List<UOM> getAlUOMs() {
		List<UOM> UOMs = new ArrayList<>();
		UOMRepository.findAll().forEach(UOMs::add);
		return UOMs;
	}

	public void addUOM(UOM UOM) {
		UOMRepository.save(UOM);
	}

	public void deleteUOM (UOM UOM) {
		UOMRepository.delete(UOM);
	}

	public UOM searchUOMById (Long Id) {
		Optional<UOM> optionalUOM = UOMRepository.findById(Id);
		if(optionalUOM.isPresent()) {
			return optionalUOM.get();
		}
		return  null;
	}


	public void searchUOMByIds (List<Long> Ids) {
		UOMRepository.findAllById(Ids);
	}
}
