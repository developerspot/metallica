package com.online.trading.service;

/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
import java.util.List;

import com.online.trading.model.TradeModel;

public interface TradeService {

	public TradeModel save(TradeModel tradeModel);

	public TradeModel update(TradeModel tradeModel);

	public void delete(TradeModel tradeModel);

	public List<TradeModel> getAllTrades();
	
	public TradeModel findTradeById(String tradeId);
}
