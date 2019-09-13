package com.online.trading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*
 * The only key part here is the @EnableEurekaServer annotation. This turns the application into a Eureka server
 * It is extremely easy to turn a service into a running Eureka server for service registration and discovery
 */
@EnableEurekaServer
@SpringBootApplication
public class TradeDiscoveryMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeDiscoveryMicroserviceApplication.class, args);
	}

}
