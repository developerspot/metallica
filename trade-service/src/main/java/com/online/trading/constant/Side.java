package com.online.trading.constant;

/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
public enum Side {

	BUY(1), SELL(2);

	private final int tradeCode;

	Side(int tradeCode) {
		this.tradeCode = tradeCode;
	}

	public int getTradeCode() {
		return this.tradeCode;
	}
}
