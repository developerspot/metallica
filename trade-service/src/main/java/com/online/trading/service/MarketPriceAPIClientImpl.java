package com.online.trading.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.online.trading.model.MarketPrice;

@Service
public class MarketPriceAPIClientImpl implements MarketPriceAPIClient {


	@Autowired
	private RestTemplate restTemplate;

	public List<MarketPrice> getCurrentMarketPrice() {
		String marketDataServiceUrl = "http://MARKETDATA-SERVICE/v1/prices";
		ResponseEntity<List<MarketPrice>> resExchange = restTemplate.exchange(marketDataServiceUrl, HttpMethod.GET,
				null, new ParameterizedTypeReference<List<MarketPrice>>() {
				});
		List<MarketPrice> marketPriceList = resExchange.getBody();
		marketPriceList.stream().forEach(e -> System.out.println(e.toString()));
		return marketPriceList;
	}

}
