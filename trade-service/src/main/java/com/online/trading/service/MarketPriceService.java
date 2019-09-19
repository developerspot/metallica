/**
 * 
 */
package com.online.trading.service;

import java.util.List;
import java.util.Optional;

import com.online.trading.model.MarketPrice;

/**
 * @author rampraja1
 * @date 2019-Sep-18 8:16:47 PM
 */
public interface MarketPriceService {

	public MarketPrice create(MarketPrice marketPrice);

	public MarketPrice update(MarketPrice marketPrice);

	public void delete(MarketPrice marketPrice);

	public List<MarketPrice> findAll();

	public Optional<MarketPrice> findById(Long id);
}
