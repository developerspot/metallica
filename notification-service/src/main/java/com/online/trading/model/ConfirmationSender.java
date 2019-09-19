/**
 * 
 */
package com.online.trading.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author rampraja1
 * @date 2019-Sep-19 12:54:05 PM
 */
@Component
public class ConfirmationSender {

	private Logger logger = LoggerFactory.getLogger(ConfirmationSender.class);

	@Autowired
	JmsTemplate jmsTemplate;

	public void sendMessage(final Confirmation confirmation) {
		jmsTemplate.convertAndSend("confirmationQueue", confirmation);
		logger.info(" >>  Send confirmation: " + confirmation);
	}
}