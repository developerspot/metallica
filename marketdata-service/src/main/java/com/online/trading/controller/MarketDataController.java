package com.online.trading.controller;

/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.trading.exception.ResourceNotFoundException;
import com.online.trading.model.CounterParty;
import com.online.trading.model.MarketPrice;
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
@RequestMapping("/v1")
public class MarketDataController {

	@Autowired
	private MarketDataService marketDataService;

	/*
	 * @RequestMapping(value = "{name}") public String getName(@PathVariable(name =
	 * "name") String name) { return "Hello  <strong style=\"color: red;\">" + name
	 * + " </strong> Responsed on : " + new Date(); }
	 */

	@GetMapping("/prices")
	public List<MarketPrice> getPrices() {
		return marketDataService.getPrices();
	}

	@GetMapping("/prices/{id}")
	public ResponseEntity<CounterParty> getPrices(@PathVariable long id) throws ResourceNotFoundException {
		CounterParty counterParty = marketDataService.findCounterPartyById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Counter Party not found for this id :: " + id));
		return ResponseEntity.ok().body(counterParty);
	}

	@PostMapping
	public String postMarketData(@Valid @RequestBody CounterParty counterParty) {
		marketDataService.addCounterParty(counterParty);
		return "MarketData Request Accepted  for storing !!";
	}

	@PutMapping
	public String putMarketData(@Valid @RequestBody CounterParty counterParty) {
		marketDataService.updateCounterParty(counterParty);
		return "MarketData Request Accepted for updation!!";
	}

	@DeleteMapping("delete/{id}")
	public Map<String, Boolean> deletMarketData(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
		CounterParty counterParty = marketDataService.findCounterPartyById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Market Price not found for this id :: " + id));
		marketDataService.deleteCounterPartyById(counterParty.getId());
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
