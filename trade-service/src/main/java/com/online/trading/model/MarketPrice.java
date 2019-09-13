package com.online.trading.model;

import java.math.BigDecimal;

public class MarketPrice {

	private BigDecimal price;
	private String commodity;

	public MarketPrice() {
		super();
	}

	public MarketPrice(BigDecimal price, String commodity) {
		super();
		this.price = price;
		this.commodity = commodity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCommodity() {
		return commodity;
	}

	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}

	@Override
	public String toString() {
		return "MarketPrice [price=" + price + ", commodity=" + commodity + "]";
	}

}
