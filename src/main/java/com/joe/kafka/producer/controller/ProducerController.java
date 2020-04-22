package com.joe.kafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joe.kafka.producer.model.User;

@RestController
@RequestMapping("/producer")
public class ProducerController {
	
	@Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    private static final String USER_TOPIC = "User_Topic";

	@GetMapping("/publish/{name}/{technology}/{salary}")
    public String post(@PathVariable("name") final String name,
    		@PathVariable("technology") final String technology,
    		@PathVariable("salary") final String salary) {

        kafkaTemplate.send(USER_TOPIC, 
        		new User(name, technology, Long.valueOf(salary)));

        return "Published successfully";
    }
	
}
