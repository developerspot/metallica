package com.online.trading.service;

import java.util.List;

import com.online.trading.model.Location;

public interface LocationService {

	public Location addLocation(Location location);

	public Location updateLocation(Location location);

	public void deleteLocationId(long id);

	public List<Location> findLocation();

	public Location findLocationById(long Id);
}
