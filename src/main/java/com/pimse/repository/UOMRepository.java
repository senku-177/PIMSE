package com.pimse.repository;

import com.pimse.model.Customer;
import com.pimse.model.UOM;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UOMRepository extends CrudRepository<UOM, Long> {
}

