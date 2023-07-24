package com.pimse.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pimse.model.CheckUser;
import com.pimse.model.User;
import com.pimse.services.UserService;
@RestController
public class LoginController {
	@Autowired
	private UserService userService;
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/login",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public String checkUser(@RequestBody CheckUser userCheck) {
		User user= userService.searchUserById(userCheck.getUserId());
		boolean u=false;
		if(user !=null && user.getPassWord().equals(userCheck.getPassWord())) {
			u=true;
		}
		if(u){
			return user.getRoleID().getRoleName();
		}
		else
			return "false";
	}
}