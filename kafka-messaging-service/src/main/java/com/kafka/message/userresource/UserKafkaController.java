package com.kafka.message.userresource;

/**
 * @author rampraja1
 * @date 2019-Sep-06 3:07:52 PM 
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.message.userresource.model.User;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiOperation(value = "View a list of Kafka Message products", response = Iterable.class)
@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved Message List"),
		@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
@RestController
@RequestMapping("/kafka")
public class UserKafkaController {

	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;

	private final String TOPIC = "kafka_template";

	/*
	 * @GetMapping("/publish/{message}") public String post(@PathVariable("message")
	 * String message) {
	 * 
	 * kafkaTemplate.send(TOPIC, message);
	 * 
	 * return "Publichsed Successful"; }
	 */

	@GetMapping("/publish/v1/{name}/{id}")
	public String jsonPost(@PathVariable("name") String name, @PathVariable("id") int id) {

		kafkaTemplate.send(TOPIC, new User(id, name, "Singh", 17000L));

		return "Publichsed Successful";
	}

	@PostMapping
	public String postKafkaMessage(@PathVariable String request) {
		return "Kafka Messaging Request Accepted  for storing !!";
	}

	@PutMapping
	public String putKafkaMessage(@PathVariable String request) {
		return "Kafka Messaging Request Accepted for updation!!";
	}

	@DeleteMapping
	public String deletKafkaMessage(@PathVariable String request) {
		return "Kafka Messaging Request Accepted for deletion !!";
	}

}
