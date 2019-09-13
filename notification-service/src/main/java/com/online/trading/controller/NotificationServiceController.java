package com.online.trading.controller;

/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationServiceController {

	@GetMapping("/notification")
	public String getNotificationMesage() {
		return "Notification Service";
	}

}
