package com.online.trading.service;

/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.online.trading.model.Location;
import com.online.trading.repository.LocationRepository;

@Service
@CacheConfig(cacheNames = { "locationcache" })
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepository;

	@Cacheable
	@Override
	public Location addLocation(Location location) {
		return locationRepository.save(location);
	}

	@CachePut
	@Override
	public Location updateLocation(Location location) {
		return locationRepository.save(location);
	}

	@CacheEvict
	@Override
	public void deleteLocationId(long id) {
		locationRepository.deleteById(id);
	}

	@Cacheable
	@Override
	public List<Location> findLocation() {
		return (List<Location>) locationRepository.findAll();
	}

	@Cacheable
	@Override
	public Optional<Location> findLocationById(long id) {
		return locationRepository.findById(id);
	}

}
