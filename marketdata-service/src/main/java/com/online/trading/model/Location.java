package com.online.trading.model;

public class Location {

	private String locationCode;

	private String locationValue;

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getLocationValue() {
		return locationValue;
	}

	public void setLocationValue(String locationValue) {
		this.locationValue = locationValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locationCode == null) ? 0 : locationCode.hashCode());
		result = prime * result + ((locationValue == null) ? 0 : locationValue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (locationCode == null) {
			if (other.locationCode != null)
				return false;
		} else if (!locationCode.equals(other.locationCode))
			return false;
		if (locationValue == null) {
			if (other.locationValue != null)
				return false;
		} else if (!locationValue.equals(other.locationValue))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Location [locationCode=" + locationCode + ", locationValue=" + locationValue + "]";
	}

}
