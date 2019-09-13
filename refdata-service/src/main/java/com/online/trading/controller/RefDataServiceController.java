package com.online.trading.controller;

/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefDataServiceController {

	@RequestMapping
	public String helloWorld() {
		return "Hello World";
	}
}
