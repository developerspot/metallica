package com.online.trading.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.trading.constant.CounterParty;
import com.online.trading.constant.Side;
import com.online.trading.constant.TradeStatus;
import com.online.trading.model.MarketPrice;
import com.online.trading.model.Trade;
import com.online.trading.model.TradeModel;

@Service
public class TradeServiceImpl implements TradeService {

	private ConcurrentHashMap<String, Trade> tradingMap = new ConcurrentHashMap<>();

	@Autowired
	private MarketPriceAPIClient priceApi;

	/*
	 * @Autowired private TradeServiceRepo repositoty;
	 */

	@Override
	public TradeModel add(TradeModel tradeModel) {
		return null;
	}

	@Override
	public TradeModel update(TradeModel tradeModel) {
		return null;
	}

	@Override
	public void delete(TradeModel tradeModel) {
	}

	@Override
	public List<TradeModel> getAllTrades() {
		//return repositoty.getAllTrades();
		List<TradeModel> list = new ArrayList<>();
		TradeModel trade = new TradeModel();
		trade.setCommodity("AL");
		trade.setCounterParty(CounterParty.DOLOR);
		trade.setTradeDate(new Date());
		trade.setSide(Side.BUY);
		trade.setStatus(TradeStatus.OPEN);
		trade.setTradeId(111111L);
		list.add(trade);

		CompletableFuture<List<MarketPrice>> cf = CompletableFuture.supplyAsync(() -> {
			return priceApi.getCurrentMarketPrice();
		});
		cf.thenAccept(cfList -> {
			cfList.forEach(e -> System.out.println(" Current Market Price for {} is {}"+ e.getCommodity()+ e.getPrice()));
			;
		}).join();

		// messageService.generateEvent(trade);
		return list;

	}

	@Override
	public TradeModel findTradeById(String tradeId) {
		return null;
	}

}
