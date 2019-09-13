package com.online.trading.controller;

/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
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
