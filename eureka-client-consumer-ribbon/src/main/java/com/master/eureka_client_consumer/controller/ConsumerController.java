package com.master.eureka_client_consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.master.eureka_client_consumer.entity.User;

@RestController
public class ConsumerController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/customer/{id}")
	public User getUserById(@PathVariable String id) {
		return restTemplate.getForObject("http://eureka-client-provider/user/getUserById/12", User.class);
	}

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@GetMapping("/test")
	public String test() {
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("eureka-client-provider");
		System.out.println(
				serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());
		return "test";
	}
}
