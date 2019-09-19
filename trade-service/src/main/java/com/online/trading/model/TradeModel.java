package com.online.trading.model;

/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.Link;

import com.online.trading.constant.CounterParty;
import com.online.trading.constant.Side;
import com.online.trading.constant.TradeStatus;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Document(collection = "tradeModel")
@ApiModel(description = "All details about the Trade Model")
public class TradeModel {

	@Id
	@ApiModelProperty(notes = "Database generate the Trade Id")
	private int id;

	@ApiModelProperty(notes = "Trade date ")
	private Date tradeDate;

	@ApiModelProperty(notes = "Trade Commodity")
	private String commodity;

	@ApiModelProperty(notes = "Trade Side")
	private Side side;

	@ApiModelProperty(notes = "Trade Quantity")
	private int quantity;

	@ApiModelProperty(notes = "Trade Price")
	private double price;

	@ApiModelProperty(notes = "trade Counter Party ")
	private CounterParty counterParty;

	@ApiModelProperty(notes = "Trade Status ")
	private TradeStatus status;

	@ApiModelProperty(notes = "Trade Location ")
	private String location;

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public String getCommodity() {
		return commodity;
	}

	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}

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

	public CounterParty getCounterParty() {
		return counterParty;
	}

	public void setCounterParty(CounterParty counterParty) {
		this.counterParty = counterParty;
	}

	public TradeStatus getStatus() {
		return status;
	}

	public void setStatus(TradeStatus status) {
		this.status = status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commodity == null) ? 0 : commodity.hashCode());
		result = prime * result + ((counterParty == null) ? 0 : counterParty.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantity;
		result = prime * result + ((side == null) ? 0 : side.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tradeDate == null) ? 0 : tradeDate.hashCode());
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
		TradeModel other = (TradeModel) obj;
		if (commodity == null) {
			if (other.commodity != null)
				return false;
		} else if (!commodity.equals(other.commodity))
			return false;
		if (counterParty != other.counterParty)
			return false;
		if (id != other.id)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (quantity != other.quantity)
			return false;
		if (side != other.side)
			return false;
		if (status != other.status)
			return false;
		if (tradeDate == null) {
			if (other.tradeDate != null)
				return false;
		} else if (!tradeDate.equals(other.tradeDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TradeModel [tradeId=" + id + ", tradeDate=" + tradeDate + ", commodity=" + commodity + ", side=" + side
				+ ", quantity=" + quantity + ", price=" + price + ", counterParty=" + counterParty + ", status="
				+ status + ", location=" + location + "]";
	}

	public void add(Link withSelfRel) {

	}

}
