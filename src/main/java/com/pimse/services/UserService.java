package com.pimse.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pimse.model.User;
import com.pimse.repository.UserRepository;
@Service
public class UserService {
	@Autowired
	private UserRepository UserRepository;

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		UserRepository.findAll().forEach(users::add);
		return users;
	}


	public void addUser(User user) {
		UserRepository.save(user);
	}

	public void deleteUser (User user) {
		UserRepository.delete(user);
	}

	public User searchUserById (String Id) {
		Optional<User> optionalUser = UserRepository.findById(Id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		return  null;
	}


	public void searchVendorByIds (List<String> Ids) {
		UserRepository.findAllById(Ids);
	}



}
