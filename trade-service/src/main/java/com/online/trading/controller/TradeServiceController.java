package com.online.trading.controller;

/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.online.trading.model.TradeModel;
import com.online.trading.service.TradeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiOperation(value = "View a list of Trade Data Service details ", response = Iterable.class)
@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved Trade Data Service"),
		@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

@RestController
@RequestMapping("/v1")
public class TradeServiceController {

	/**
	 * TradeService instance
	 */
	@Autowired
	private TradeService tradeService;
	private static final Logger logger = LoggerFactory.getLogger(TradeServiceController.class);

	/**
	 * Getter Method to get all trades registered with the system
	 * 
	 * @return List<Trade> List of Registered Trades
	 */
	@ApiOperation(value = "View a Trade Data Service details ", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved Market Data Service"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	public List<TradeModel> getAllTrades() {
		logger.info("invoked getAllTrades");
		return tradeService.getAllTrades().stream().map(trade -> {
			trade.add(ControllerLinkBuilder.linkTo(TradeServiceController.class).slash(trade.getId()).withSelfRel());
			return trade;

		}).collect(Collectors.toList());
	}

	/**
	 * Getter Method to get Trade by Trade Id
	 * 
	 * @param tradeId String
	 * @return Trade
	 */
	@ApiOperation(value = "View a Market Data Service details by trade Id ", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved Market Data Service"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(path = "/{tradeId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Optional<TradeModel> getTradeById(@PathVariable("tradeId") String tradeId) {
		logger.info("Controller Layer: getTradeById for TradeId <<" + tradeId);
		Optional<TradeModel> tradeModel = tradeService.findTradeById(Long.valueOf(tradeId));
		return tradeModel;
	}

	/**
	 * save new trade
	 * 
	 * @param TradeModel tradeModel
	 * @return TradeModel
	 */

	@ApiOperation(value = "Create a new Trade Data ", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved Market Data Service"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TradeModel saveNewTrade(@RequestBody TradeModel tradeModel) {
		TradeModel savedTradeModel = tradeService.save(tradeModel);
		savedTradeModel.add(ControllerLinkBuilder.linkTo(TradeServiceController.class).slash(savedTradeModel.getId())
				.withSelfRel());
		return savedTradeModel;
	}

	/**
	 * This is used to test the message.for API.
	 * 
	 * @return Map<String, Object>
	 */
	@ApiOperation(value = "Just test API hello message ", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved Market Data Service"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/hello")
	public Map<String, Object> greeting() {
		return Collections.singletonMap("message", "Hello World");
	}

	@ApiOperation(value = "Create a new Trade Data & store into Database ", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved Market Data Service"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PostMapping(value = "/create")
	@ResponseStatus(HttpStatus.CREATED)
	TradeModel create(@RequestBody @Valid TradeModel tradeModel) {
		return tradeService.save(tradeModel);
	}

	@ApiOperation(value = "Delete a trade Data from database ", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved Market Data Service"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@DeleteMapping(value = "/delete/{id}")
	void delete(@PathVariable("id") String id) {
		TradeModel tradeModel = new TradeModel();
		tradeModel.setId(Integer.valueOf(id));
		tradeService.delete(tradeModel);
	}

	@ApiOperation(value = "View a All Trade Data from database ", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved Market Data Service"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/getall")
	List<TradeModel> findAll() {
		return tradeService.getAllTrades();
	}

	@ApiOperation(value = "View a trade Data from database by trade Id ", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved Market Data Service"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/getbyid/{id}")
	Optional<TradeModel> findById(@PathVariable("id") String id) {
		return tradeService.findTradeById(Long.valueOf(id));
	}

	@ApiOperation(value = "Update trade data into database by trade id ", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved Market Data Service"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PutMapping(value = "/update/{id}")
	TradeModel update(@RequestBody @Valid TradeModel todoEntry) {
		return tradeService.update(todoEntry);
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ApiOperation(value = "Exception & Error Message handler", response = Iterable.class)
	public void handleExceptionNotFound(Exception ex) {
	}
}
