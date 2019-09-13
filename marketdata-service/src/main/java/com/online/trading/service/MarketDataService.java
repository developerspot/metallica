package com.online.trading.service;

import java.util.List;

import com.online.trading.model.CounterParty;

public interface MarketDataService {

	public CounterParty addCounterParty(CounterParty counterParty);

	public CounterParty updateCounterParty(CounterParty counterParty);

	public void deleteCounterPartyById(long id);

	public List<CounterParty> findCounterParty();

	public CounterParty findCounterPartyById(long Id);
}
