package com.online.trading.service;

/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.trading.model.CounterParty;
import com.online.trading.repository.CounterPartyRepository;

@Service
public class MarketDataServiceImpl implements MarketDataService {

	@Autowired
	private CounterPartyRepository counterPartyRepository;

	@Override
	public CounterParty addCounterParty(CounterParty counterParty) {
		return counterPartyRepository.save(counterParty);
	}

	@Override
	public CounterParty updateCounterParty(CounterParty counterParty) {
		return counterPartyRepository.save(counterParty);
	}

	@Override
	public void deleteCounterPartyById(long id) {
		counterPartyRepository.deleteById(id);
	}

	@Override
	public List<CounterParty> findCounterParty() {
		return (List<CounterParty>) counterPartyRepository.findAll();
	}

	@Override
	public Optional<CounterParty> findCounterPartyById(long id) {
		return counterPartyRepository.findById(id);
	}

}
