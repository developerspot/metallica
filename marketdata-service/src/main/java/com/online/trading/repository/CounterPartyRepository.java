/**
 * 
 */
package com.online.trading.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.online.trading.model.CounterParty;

/**
 * @author rampraja1
 * @date 2019-Sep-13 5:20:36 PM
 */
@Repository
public interface CounterPartyRepository extends CrudRepository<CounterParty, Long> {

}
