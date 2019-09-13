/**
 * 
 */
package com.online.trading.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.online.trading.model.Location;

/**
 * @author rampraja1
 * @date 2019-Sep-13 5:19:39 PM
 */
@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {

}
