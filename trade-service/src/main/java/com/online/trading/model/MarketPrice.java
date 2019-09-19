package com.online.trading.model;

/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Document(collection = "marketPrice")
@ApiModel(description = "All details about the Market Price. ")
public class MarketPrice {

	@Id
	@ApiModelProperty(notes = "The database generated Market Price ID")
	private long id;

	@ApiModelProperty(notes = "Market Price value ")
	private BigDecimal price;

	@ApiModelProperty(notes = "Market Price Commodity ")
	private String commodity;

	public MarketPrice() {
		super();
	}

	public MarketPrice(BigDecimal price, String commodity) {
		super();
		this.price = price;
		this.commodity = commodity;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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
