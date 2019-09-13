package com.online.trading.service;

/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
import java.util.List;

import com.online.trading.model.CounterParty;

public interface MarketDataService {

	public CounterParty addCounterParty(CounterParty counterParty);

	public CounterParty updateCounterParty(CounterParty counterParty);

	public void deleteCounterPartyById(long id);

	public List<CounterParty> findCounterParty();

	public CounterParty findCounterPartyById(long Id);
}
