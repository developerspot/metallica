package com.kafka.message.userresource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.message.userresource.model.User;

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

	@GetMapping("/publish/v1/{name}")
	public String jsonPost(@PathVariable("name") String name) {

		kafkaTemplate.send(TOPIC, new User(name, "Singh", 17000L));

		return "Publichsed Successful";
	}
}
