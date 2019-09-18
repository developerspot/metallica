package com.online.trading.service;

/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.online.trading.constant.CounterParty;
import com.online.trading.constant.Side;
import com.online.trading.constant.TradeStatus;
import com.online.trading.model.MarketPrice;
import com.online.trading.model.TradeModel;
import com.online.trading.repo.TradeServiceRepo;

@Service
public class TradeServiceImpl implements TradeService {

	private static final Logger logger = LoggerFactory.getLogger(TradeServiceImpl.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private EurekaClient eurekaClient;

	@Autowired
	private TradeServiceRepo repositoty;

	@Override
	public TradeModel save(TradeModel tradeModel) {
		return repositoty.save(tradeModel);
	}

	@Override
	public TradeModel update(TradeModel tradeModel) {
		return repositoty.update(tradeModel);
	}

	@Override
	public void delete(TradeModel tradeModel) {
		repositoty.delete(tradeModel);
	}

	@Override
	public List<TradeModel> getAllTrades() {
		List<TradeModel> list = new ArrayList<>();
		TradeModel trade = new TradeModel();
		trade.setCommodity("AL");
		trade.setCounterParty(CounterParty.DOLOR);
		trade.setTradeDate(new Date());
		trade.setSide(Side.BUY);
		trade.setStatus(TradeStatus.OPEN);
		trade.setId(9999L);
		list.add(trade);

		CompletableFuture<List<MarketPrice>> cf = CompletableFuture.supplyAsync(() -> {
			return getCurrentMarketPrice();
		});
		cf.thenAccept(cfList -> {
			cfList.forEach(
					e -> System.out.println(" Current Market Price for {} is {}" + e.getCommodity() + e.getPrice()));
			;
		}).join();

		return list;

	}

	@Override
	public TradeModel findTradeById(String tradeId) {
		return repositoty.findTradeById(tradeId);
	}

	private List<MarketPrice> getCurrentMarketPrice() {
		logger.info(" getCurrentMarketPrice invoked !!!");
		Application application = eurekaClient.getApplication("MARKETDATA-SERVICE");
		InstanceInfo instanceInfo = application.getInstances().get(0);
		String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "v1/prices";
		System.out.println("URL" + url);

		ResponseEntity<List<MarketPrice>> resExchange = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<MarketPrice>>() {
				});
		List<MarketPrice> marketPriceList = resExchange.getBody();
		marketPriceList.stream().forEach(e -> System.out.println(e.toString()));
		return marketPriceList;
	}

}
