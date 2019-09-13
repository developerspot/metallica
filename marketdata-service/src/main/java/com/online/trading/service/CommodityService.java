package com.online.trading.service;

/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
import java.util.List;

import com.online.trading.model.Commodity;

public interface CommodityService {

	public Commodity addCommodities(Commodity commodities);

	public Commodity updateCommodities(Commodity commodities);

	public void deleteCommoditiesId(long id);

	public List<Commodity> findCommodities();

	public Commodity findCommoditiesId(long Id);
}
