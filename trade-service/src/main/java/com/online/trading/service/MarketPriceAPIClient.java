package com.online.trading.service;

/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
import java.util.List;

import com.online.trading.model.MarketPrice;

public interface MarketPriceAPIClient {

	public List<MarketPrice> getCurrentMarketPrice();
}
