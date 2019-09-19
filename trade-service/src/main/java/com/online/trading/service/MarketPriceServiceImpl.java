/**
 * 
 */
package com.online.trading.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.online.trading.model.MarketPrice;
import com.online.trading.repo.MarketPriceRepo;

/**
 * @author rampraja1
 * @date 2019-Sep-18 8:19:24 PM
 */
@Service
@CacheConfig(cacheNames = { "marketpricecache" })
public class MarketPriceServiceImpl implements MarketPriceService {

	@Autowired
	private MarketPriceRepo marketPriceRepo;

	@Cacheable
	@Override
	public MarketPrice create(MarketPrice marketPrice) {
		return marketPriceRepo.save(marketPrice);
	}

	@CachePut
	@Override
	public MarketPrice update(MarketPrice marketPrice) {
		return marketPriceRepo.save(marketPrice);
	}

	@CacheEvict
	@Override
	public void delete(MarketPrice marketPrice) {
		marketPriceRepo.delete(marketPrice);
	}

	@Cacheable
	@Override
	public List<MarketPrice> findAll() {
		return marketPriceRepo.findAll();
	}

	@Cacheable
	@Override
	public Optional<MarketPrice> findById(Long id) {
		return marketPriceRepo.findById(id);
	}

}
