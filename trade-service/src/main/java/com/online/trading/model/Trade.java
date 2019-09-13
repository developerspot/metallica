package com.online.trading.model;

import java.io.Serializable;
import java.util.Date;

import com.online.trading.constant.Side;
import com.online.trading.constant.TradeStatus;

/*  Trade Class which contains the information/attributes for Counterparty, commodity & Location
 * 
 * 
 */

public class Trade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3916799568276833414L;

	private long tradeId;
	private Side side;
	private int quantity;
	private double price;
	private Date tradedate;
	private TradeStatus status;

	public Side getSide() {
		return side;
	}

	public void setSide(Side side) {
		this.side = side;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getTradedate() {
		return tradedate;
	}

	public void setTradedate(Date tradedate) {
		this.tradedate = tradedate;
	}

	public TradeStatus getStatus() {
		return status;
	}

	public void setStatus(TradeStatus status) {
		this.status = status;
	}

	public long getTradeId() {
		return tradeId;
	}

	public void setTradeId(long tradeId) {
		this.tradeId = tradeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantity;
		result = prime * result + ((side == null) ? 0 : side.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tradedate == null) ? 0 : tradedate.hashCode());
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
		Trade other = (Trade) obj;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (quantity != other.quantity)
			return false;
		if (side != other.side)
			return false;
		if (status != other.status)
			return false;
		if (tradedate == null) {
			if (other.tradedate != null)
				return false;
		} else if (!tradedate.equals(other.tradedate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Trade [side=" + side + ", quantity=" + quantity + ", price=" + price + ", tradedate=" + tradedate
				+ ", status=" + status + "]";
	}

}
