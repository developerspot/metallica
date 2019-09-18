package com.online.trading.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.online.trading.model.TradeModel;

@Repository
public interface TradeServiceRepo extends MongoRepository<TradeModel, Long> {

}
