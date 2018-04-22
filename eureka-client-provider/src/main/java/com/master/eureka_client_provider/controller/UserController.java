package com.master.eureka_client_provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.master.eureka_client_provider.entity.User;

@RestController
public class UserController {
	
	@GetMapping("/user/getUserById/{id}")
	//@RequestMapping(value="/user/getUserById/{id}",method=RequestMethod.GET) 同上
	public User getUserById(@PathVariable String id){
		User user = new User();
		user.setUserName("Liming");
		user.setGender("male");
		return user;
		
	}

}
