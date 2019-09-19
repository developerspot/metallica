package com.online.trading;
/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */

import javax.jms.ConnectionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import com.online.trading.model.User;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJms
public class NotificationServiceApplication {
	private static Logger logger = LoggerFactory.getLogger(NotificationServiceApplication.class);

	String BROKER_URL = "tcp://localhost:61616";
	String BROKER_USERNAME = "admin";
	String BROKER_PASSWORD = "admin";

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(NotificationServiceApplication.class, args);

		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

		// Send an user
		logger.info("Sending an user message.");
		jmsTemplate.convertAndSend("inbound.queue", new User("ram.prajapati@publicissapient.com", 2d, true));

		logger.info("Waiting for user and confirmation ...");
		System.in.read();
		context.close();
	}

	@Bean // Serialize message content to json using TextMessage
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}

	@Bean
	public JmsListenerContainerFactory<?> connectionFactory(ConnectionFactory connectionFactory,
			DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		// This provides all boot's default to this factory, including the message
		// converter
		configurer.configure(factory, connectionFactory);
		// You could still override some of Boot's default if necessary.
		return factory;
	}
}
