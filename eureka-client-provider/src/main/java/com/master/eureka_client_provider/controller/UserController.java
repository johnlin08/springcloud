package com.master.eureka_client_provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.master.eureka_client_provider.entity.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class UserController {
	
	@GetMapping("/user/getUserById/{id}")
	//@RequestMapping(value="/user/getUserById/{id}",method=RequestMethod.GET) 同上
	public User getUserById(@PathVariable String id){
		User user = new User();
		user.setUserName("Liming");
		user.setGender("male");
		System.out.println("-========-");

		return user;
		
	}

	 @Autowired
	  private EurekaClient eurekaClient;

	  @Autowired
	  private DiscoveryClient discoveryClient;

	
	  @GetMapping("/eureka-instance")
	  public String serviceUrl() {
	    InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER", false);
	    return instance.getHomePageUrl();
	  }

	  @GetMapping("/instance-info")
	  public ServiceInstance showInfo() {
	    ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
	    return localServiceInstance;
	  }
}
