package com.online.trading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
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

	private static final Logger LOGGER = LoggerFactory.getLogger(TradeDiscoveryMicroserviceApplication.class);
	public static void main(String[] args) {

		LOGGER.info("Main Method Invoke !!");
		SpringApplication.run(TradeDiscoveryMicroserviceApplication.class, args);
	}

}
