package com.online.trading.constant;

public enum TradeStatus {

	OPEN("O"), NOMINATED("N");

	private final String status;

	private TradeStatus(String status) {
		this.status = status;
	}

	public String getSatusCode() {
		return this.status;
	}
}
