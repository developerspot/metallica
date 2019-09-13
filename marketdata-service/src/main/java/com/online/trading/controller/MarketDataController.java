package com.online.trading.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/")
public class MarketDataController {

	@RequestMapping(value = "{name}")
	public String getName(@PathVariable(name = "name") String name) {
		return "Hello  <strong style=\"color: red;\">" + name + " </strong> Responsed on : " + new Date();
	}
	
	
	
}
