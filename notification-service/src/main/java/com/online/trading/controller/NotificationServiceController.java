package com.online.trading.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationServiceController {

	@GetMapping("/notification")
	public String getNotificationMesage() {
		return "Notification Service";
	}

}
