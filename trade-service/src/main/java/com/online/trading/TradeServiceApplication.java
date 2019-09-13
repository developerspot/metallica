package com.online.trading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class TradeServiceApplication {

	public static final String TRADE_SERVICE_URL = "http://TRADE-MICROSERVICE";

	public static void main(String[] args) {
		SpringApplication.run(TradeServiceApplication.class, args);
	}

	@Bean

	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
