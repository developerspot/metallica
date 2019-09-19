/**
 * 
 */
package com.online.trading.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.online.trading.model.MarketPrice;

/**
 * @author rampraja1
 * @date 2019-Sep-18 8:15:55 PM 
 */
@Repository
public interface MarketPriceRepo extends MongoRepository<MarketPrice, Long> {

}
