package com.online.trading.repo;

/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.online.trading.model.TradeModel;

@Repository
public interface TradeServiceRepo extends MongoRepository<TradeModel, Long> {

	public TradeModel save(TradeModel tradeModel);

	public TradeModel update(TradeModel tradeModel);

	public void delete(TradeModel tradeModel);

	public List<TradeModel> findAll();

	public TradeModel findTradeById(String tradeId);
}
