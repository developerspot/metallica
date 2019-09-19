package com.online.trading.controller;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiOperation(value = "View a list of Notification Service details ", response = Iterable.class)
@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved  Market Data Service"),
		@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

@RestController
@CacheConfig(cacheNames = { "notificationcache" })
public class NotificationServiceController {

	@Cacheable
	@GetMapping("/notification")
	public String getNotificationMesage() {
		return "Notification Service";
	}

	@Cacheable
	@GetMapping
	public String getNotification() {

		return "Notification service";
	}

	@Cacheable
	@PostMapping
	public String postNotification(@PathVariable String request) {
		return "Notification Request Accepted  for storing !!";
	}

	@CachePut
	@PutMapping
	public String putNotification(@PathVariable String request) {
		return "Notification Request Accepted for updation!!";
	}

	@CacheEvict
	@DeleteMapping
	public String deletNotification(@PathVariable String request) {
		return "Notification Request Accepted for deletion !!";
	}
}
