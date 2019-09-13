package com.online.trading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RefdataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RefdataServiceApplication.class, args);
	}

}
