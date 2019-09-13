package com.online.trading.service;

import java.util.List;

import com.online.trading.model.MarketPrice;

public interface MarketPriceAPIClient {

	public List<MarketPrice> getCurrentMarketPrice();
}
