package com.online.trading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
public class RefdataServiceApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(RefdataServiceApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Main Method invoked !!!");
		SpringApplication.run(RefdataServiceApplication.class, args);
	}

}
