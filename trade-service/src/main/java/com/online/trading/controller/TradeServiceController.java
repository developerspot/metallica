package com.online.trading.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.trading.model.TradeModel;
import com.online.trading.service.TradeService;

@RestController
@RequestMapping("/v1/trades")
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
		@GetMapping( produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
		public List<TradeModel> getAllTrades() {
			logger.info("invoked getAllTrades");
			return tradeService.getAllTrades().stream().map(trade -> {
				trade.add(ControllerLinkBuilder.linkTo(TradeServiceController.class).slash(trade.getTradeId()).withSelfRel());
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
			tradeModel.add(ControllerLinkBuilder.linkTo(TradeServiceController.class).slash(tradeModel.getTradeId()).withSelfRel());
			return tradeModel;
		}

		@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public TradeModel saveNewTrade(@RequestBody TradeModel tradeModel) {
			TradeModel savedTradeModel = tradeService.add(tradeModel);
			savedTradeModel.add(ControllerLinkBuilder.linkTo(TradeServiceController.class).slash(savedTradeModel.getTradeId()).withSelfRel());
			return savedTradeModel;
		}

		@GetMapping("/hello")
		public Map<String, Object> greeting() {
			return Collections.singletonMap("message", "Hello World");
		}

	}
