package com.online.trading.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefDataServiceController {

	@RequestMapping
	public String helloWorld() {
		return "Hello World";
	}
}
