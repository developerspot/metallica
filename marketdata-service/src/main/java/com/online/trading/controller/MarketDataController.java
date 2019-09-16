package com.online.trading.controller;

/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.trading.service.MarketDataService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiOperation(value = "View a list of Market Data Service details ", response = Iterable.class)
@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved  Market Data Service"),
		@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

@RestController
@RequestMapping("/v1/")
public class MarketDataController {

	@Autowired
	private MarketDataService marketDataService;

	@RequestMapping(value = "{name}")
	public String getName(@PathVariable(name = "name") String name) {
		return "Hello  <strong style=\"color: red;\">" + name + " </strong> Responsed on : " + new Date();
	}

	@GetMapping(value = "/prices", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MarketPrice> getPrices() {
		return marketDataService.getPrices();
	}

	@PostMapping
	public String postMarketData(@PathVariable String request) {
		return "MarketData Request Accepted  for storing !!";
	}

	@PutMapping
	public String putMarketData(@PathVariable String request) {
		return "MarketData Request Accepted for updation!!";
	}

	@DeleteMapping
	public String deletMarketData(@PathVariable String request) {
		return "MarketData Request Accepted for deletion !!";
	}

}
