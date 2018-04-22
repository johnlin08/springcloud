package com.master.eureka_client_consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.master.eureka_client_consumer.entity.User;


@RestController
public class ConsumerController {

	@Autowired
	private RestTemplate restTemplate ; 
	
	@GetMapping("/customer/{id}")
	public User getUserById(@PathVariable String id){
		return restTemplate.getForObject("http://localhost:8762/user/getUserById/12", User.class);
	}
}
