/**
 * 
 */
package com.online.trading.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.trading.model.MarketPrice;
import com.online.trading.repo.MarketPriceRepo;

/**
 * @author rampraja1
 * @date 2019-Sep-18 8:19:24 PM
 */
@Service
public class MarketPriceServiceImpl implements MarketPriceService {

	@Autowired
	private MarketPriceRepo marketPriceRepo;

	@Override
	public MarketPrice create(MarketPrice marketPrice) {
		return marketPriceRepo.save(marketPrice);
	}

	@Override
	public MarketPrice update(MarketPrice marketPrice) {
		return marketPriceRepo.save(marketPrice);
	}

	@Override
	public void delete(MarketPrice marketPrice) {
		marketPriceRepo.delete(marketPrice);
	}

	@Override
	public List<MarketPrice> findAll() {
		return marketPriceRepo.findAll();
	}

	@Override
	public Optional<MarketPrice> findById(Long id) {
		return marketPriceRepo.findById(id);
	}

}
