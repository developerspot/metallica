package com.online.trading.service;

/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
import java.util.List;
import java.util.Optional;

import com.online.trading.model.CounterParty;
import com.online.trading.model.MarketPrice;

public interface MarketDataService {

	public CounterParty addCounterParty(CounterParty counterParty);

	public CounterParty updateCounterParty(CounterParty counterParty);

	public void deleteCounterPartyById(long id);

	public List<CounterParty> findCounterParty();

	public Optional<CounterParty> findCounterPartyById(long Id);
	
	public List<MarketPrice> getPrices();
}
