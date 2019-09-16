package com.online.trading.controller;

import javax.ws.rs.OPTIONS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefDataServiceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RefDataServiceController.class);

	@RequestMapping
	public String helloWorld() {
		LOGGER.info("Request for Hello World Message");
		return "Hello World";
	}

	@GetMapping
	public String getRefData() {

		return "reference Data service";
	}

	@PostMapping
	public String postRefData(@PathVariable String request) {
		return "Reference Data Request Accepted  for storing !!";
	}

	@PutMapping
	public String putRefData(@PathVariable String request) {
		return "Reference Data Request Accepted for updation!!";
	}

	@DeleteMapping
	public String deletRefData(@PathVariable String request) {
		return "Reference Data Request Accepted for deletion !!";
	}
}
