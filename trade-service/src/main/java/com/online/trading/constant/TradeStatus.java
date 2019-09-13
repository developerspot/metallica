package com.online.trading.constant;

/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
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
