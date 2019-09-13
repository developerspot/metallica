package com.thread;

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
