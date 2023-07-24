package com.pimse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.pimse.model.User;
import com.pimse.services.UserService;
@RestController
public class UserController {
	
	@Autowired
	private UserService UserService;
	
	@RequestMapping(value="/get-user",method=RequestMethod.GET,produces="application/json")
	public List<User> getAllUsers() {
		return UserService.getAllUsers();
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value = "/add-user", method = RequestMethod.POST,
			consumes = "application/json")
	public boolean addUser(@RequestBody User UserRecord) {
		User user=UserService.searchUserById(UserRecord.getUserId());
		if(user==null){
			if(UserRecord.getRoleID().getRoleName().equals("Stocker"))
				UserRecord.getRoleID().setRoleId("STOCK");
			else if(UserRecord.getRoleID().getRoleName().equals("Cashier"))
				UserRecord.getRoleID().setRoleId("CASH");
			else if(UserRecord.getRoleID().getRoleName().equals("Administrator"))
				UserRecord.getRoleID().setRoleId("Admin");
			UserRecord.setActive(true);
			UserService.addUser(UserRecord);
			return true;
		}
		else{
			return false;
		}
	}
}
