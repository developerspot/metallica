package com.online.trading.controller;

/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@GetMapping(path = "/{tradeId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TradeModel getTradeById(@PathVariable("tradeId") String tradeId) {
		logger.info("Controller Layer: getTradeById for TradeId <<" + tradeId);
		TradeModel tradeModel = tradeService.findTradeById(tradeId);
		tradeModel.add(
				ControllerLinkBuilder.linkTo(TradeServiceController.class).slash(tradeModel.getId()).withSelfRel());
		return tradeModel;
	}

	/**
	 * save new trade
	 * 
	 * @param TradeModel tradeModel
	 * @return TradeModel
	 */

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
	@GetMapping("/hello")
	public Map<String, Object> greeting() {
		return Collections.singletonMap("message", "Hello World");
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	TradeModel create(@RequestBody @Valid TradeModel todoEntry) {
		return tradeService.save(todoEntry);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	void delete(@PathVariable("id") String id) {
		TradeModel tradeModel = new TradeModel();
		tradeModel.setId(Long.valueOf(id));
		tradeService.delete(tradeModel);
	}

	@RequestMapping(method = RequestMethod.GET)
	List<TradeModel> findAll() {
		return tradeService.getAllTrades();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	TradeModel findById(@PathVariable("id") String id) {
		return tradeService.findTradeById(id);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	TradeModel update(@RequestBody @Valid TradeModel todoEntry) {
		return tradeService.update(todoEntry);
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public void handleTodoNotFound(Exception ex) {
	}
}
