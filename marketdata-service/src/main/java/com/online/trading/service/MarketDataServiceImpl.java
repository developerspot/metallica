package com.online.trading.service;

/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.trading.model.CounterParty;
import com.online.trading.model.MarketPrice;
import com.online.trading.repository.CounterPartyRepository;

@Service
public class MarketDataServiceImpl implements MarketDataService {

	private static final Logger logger = LoggerFactory.getLogger(MarketDataService.class);

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

	public List<MarketPrice> getPrices() {

		logger.info(" Executing prices() to get Latest Prices for the Commodities ");
		Map<String, Object> priceMap = getCounterPartyMap().entrySet().stream().map(Map.Entry::getKey)
				.collect(Collectors.toMap(Function.identity(), e -> Math.random() , (e1, e2) -> e1,
						HashMap::new));

		return priceMap.entrySet().stream()
				.map(entry -> new MarketPrice(new BigDecimal((char[]) entry.getValue(),new MathContext(2)), entry.getKey()))
				.collect(Collectors.toList());

	}

	private Map<String, String> getCounterPartyMap() {
		Map<String, String> COUNTERPARTY_MAP = new HashMap<String, String>();
		COUNTERPARTY_MAP.put("Lorem", "Lorem");
		COUNTERPARTY_MAP.put("Ipsum", "Ipsum");
		COUNTERPARTY_MAP.put("Dolor", "Dolor");
		COUNTERPARTY_MAP.put("Amet", "Amet");
		return COUNTERPARTY_MAP;
	}

	private Map<String, String> getLocationMap() {

		Map<String, String> LOCATIONS_MAP = new HashMap<String, String>();
		LOCATIONS_MAP.put("LN", "London");
		LOCATIONS_MAP.put("NY", "New York");
		LOCATIONS_MAP.put("SG", "Singapore");
		LOCATIONS_MAP.put("DN", "Denver");
		return LOCATIONS_MAP;
	}

	private Map<String, String> getCommodityMap() {
		Map<String, String> COMMODITIES_MAP = new HashMap<String, String>();
		COMMODITIES_MAP.put("AL", "Aluminium");
		COMMODITIES_MAP.put("ZN", "Zinc");
		COMMODITIES_MAP.put("CU", "Copper");
		COMMODITIES_MAP.put("AG", "Silver");
		COMMODITIES_MAP.put("AU", "Gold");
		return COMMODITIES_MAP;
	}
}
