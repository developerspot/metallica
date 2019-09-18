/**
 * 
 */
package com.online.trading.controller;

import java.math.BigDecimal;

/**
 * @author rampraja1
 * @date 2019-Sep-14 7:39:23 PM
 */
public class MarketPrice {

	private BigDecimal price;
	private String commodity;

	public MarketPrice(BigDecimal price, String commodity) {
		super();
		this.price = price;
		this.commodity = commodity;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return the commodity
	 */
	public String getCommodity() {
		return commodity;
	}

	/**
	 * @param commodity the commodity to set
	 */
	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commodity == null) ? 0 : commodity.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
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
		MarketPrice other = (MarketPrice) obj;
		if (commodity == null) {
			if (other.commodity != null)
				return false;
		} else if (!commodity.equals(other.commodity))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MarketPrice [price=" + price + ", commodity=" + commodity + "]";
	}

}
