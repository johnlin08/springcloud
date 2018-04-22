package com.master.eureka_client_consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;


@Configuration
@ExcludeFromComponentScan
public class TestConfiguration {
  //  @Autowired
  //  IClientConfig config;

 /*
  * 自定义ribbon 负载均衡规则
  * 
  */
  @Bean
  public IRule ribbonRule() {
    return new RandomRule();
  }
}
