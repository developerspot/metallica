/**
 * 
 */
package com.online.trading.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author rampraja1
 * @date 2019-Sep-19 12:53:21 PM
 */
@Component
public class ConfirmationReceiver {

	private Logger logger = LoggerFactory.getLogger(ConfirmationReceiver.class);

	@JmsListener(destination = "confirmationQueue", containerFactory = "connectionFactory")
	public void receiveConfirmation(Confirmation confirmation) {
		logger.info(" >>  Received confirmation: " + confirmation);

	}
}