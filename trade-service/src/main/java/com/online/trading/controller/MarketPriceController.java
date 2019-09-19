/**
 * 
 */
package com.online.trading.controller;
/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.online.trading.model.MarketPrice;
import com.online.trading.service.MarketPriceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author rampraja1
 * @date 2019-Sep-18 8:22:51 PM
 */
@Api(value = "Market Data Service", description = "Operations pertaining to Market Date in Market Data Service")
@RestController
@RequestMapping("/v1/marketdata")
public class MarketPriceController {

	private final Logger logger = LoggerFactory.getLogger(MarketPriceController.class);

	@Autowired
	private MarketPriceService marketPriceService;

	@ApiOperation(value = "Create a New Market Data with passing Json Data")
	@PostMapping("/create")
	public MarketPrice create(@Valid @RequestBody() MarketPrice marketPrice) {
		logger.info("Market data Service has been Created !!!");
		return marketPriceService.create(marketPrice);
	}

	@ApiOperation(value = "Update Market Data With Market ID")
	@PutMapping("/update")
	public MarketPrice update(@Valid @RequestBody MarketPrice marketPrice) {
		logger.info("Market data Service has been Updated !!!");
		return marketPriceService.update(marketPrice);
	}

	@ApiOperation(value = "Delete Market Data With Market ID")
	@DeleteMapping("delete/{id}")
	public Map<String, Boolean> delete(@Valid @PathVariable(value = "id") long id) throws ResourceNotFoundException {
		logger.info("Market data Service has been Deleted !!!");
		MarketPrice marketPrice1 = marketPriceService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Market Price not found for this id :: " + id));
		marketPriceService.delete(marketPrice1);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@ApiOperation(value = "View a list of Market Data Service details ", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved Market Data Service"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/all")
	public List<MarketPrice> findAll() {
		logger.info("Find All Market data Service !!!");
		return marketPriceService.findAll();
	}

	@ApiOperation(value = "View a Market Data Service details ", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved Market Data Service"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/byId/{id}")
	public ResponseEntity<MarketPrice> findById(
			@ApiParam(value = "Market id from which Market Price object will retrieve", required = true) @PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		logger.info("find by id Market data Service !!!");
		MarketPrice marketPrice = marketPriceService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Market Price not found for this id :: " + id));
		return ResponseEntity.ok().body(marketPrice);
	}
}
