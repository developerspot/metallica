/**
 * 
 */
package com.online.trading.exception;

import java.util.Date;

/**
 * @author rampraja1
 * @date 2019-Sep-19 11:56:48 AM
 */
public class ErrorDetails {
	private Date timestamp;
	private String message;
	private String details;

	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
}