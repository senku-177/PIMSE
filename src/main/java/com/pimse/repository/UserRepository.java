package com.pimse.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pimse.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{
	
}