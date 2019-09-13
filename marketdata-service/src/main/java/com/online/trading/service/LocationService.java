package com.online.trading.service;

/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
import java.util.List;
import java.util.Optional;

import com.online.trading.model.Location;

public interface LocationService {

	public Location addLocation(Location location);

	public Location updateLocation(Location location);

	public void deleteLocationId(long id);

	public List<Location> findLocation();

	public Optional<Location> findLocationById(long Id);
}
