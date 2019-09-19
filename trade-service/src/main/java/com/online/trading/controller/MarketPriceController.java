/**
 * 
 */
package com.online.trading.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	@DeleteMapping("delete")
	public void delete(@Valid @RequestBody MarketPrice marketPrice) {
		logger.info("Market data Service has been Deleted !!!");
		marketPriceService.delete(marketPrice);
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
	public Optional<MarketPrice> findById(
			@ApiParam(value = "Market id from which Market Price object will retrieve", required = true) @PathVariable(value = "id") Long id) {
		logger.info("find by id Market data Service !!!");
		return marketPriceService.findById(id);
	}
}
