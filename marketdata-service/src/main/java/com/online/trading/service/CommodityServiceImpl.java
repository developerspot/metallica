package com.online.trading.service;

/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.trading.model.Commodity;
import com.online.trading.repository.CommodityRepository;

@Service
public class CommodityServiceImpl implements CommodityService {

	@Autowired
	private CommodityRepository commodityRepository;

	@Override
	public Commodity addCommodities(Commodity commodities) {
		return commodityRepository.save(commodities);
	}

	@Override
	public Commodity updateCommodities(Commodity commodities) {
		return commodityRepository.save(commodities);
	}

	@Override
	public void deleteCommoditiesId(long id) {
		commodityRepository.deleteById(id);
	}

	@Override
	public List<Commodity> findCommodities() {
		return (List<Commodity>) commodityRepository.findAll();
	}

	@Override
	public Optional<Commodity> findCommoditiesId(long id) {
		return commodityRepository.findById(id);
	}

}
