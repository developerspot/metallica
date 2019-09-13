package com.online.trading.service;

import java.util.List;

import com.online.trading.model.TradeModel;

public interface TradeService {

	public TradeModel add(TradeModel tradeModel);

	public TradeModel update(TradeModel tradeModel);

	public void delete(TradeModel tradeModel);

	public List<TradeModel> getAllTrades();
	
	public TradeModel findTradeById(String tradeId);
}
