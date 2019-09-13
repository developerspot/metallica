package com.online.trading.service;

/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.trading.model.Location;
import com.online.trading.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	@Override
	public Location addLocation(Location location) {
		return locationRepository.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		return locationRepository.save(location);
	}

	@Override
	public void deleteLocationId(long id) {
		locationRepository.deleteById(id);
	}

	@Override
	public List<Location> findLocation() {
		return (List<Location>) locationRepository.findAll();
	}

	@Override
	public Optional<Location> findLocationById(long id) {
		return locationRepository.findById(id);
	}

}
