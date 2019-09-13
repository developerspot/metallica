/**
 * 
 */
package com.online.trading.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.online.trading.model.Commodity;

/**
 * @author rampraja1
 * @date 2019-Sep-13 5:18:36 PM 
 */
@Repository
public interface CommodityRepository extends CrudRepository<Commodity, Long> { 

}
