package com.joe.kafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joe.kafka.producer.service.PersonService;
import com.joe.kafka.producer.vo.PersonVO;

@RestController
@RequestMapping("/producer")
public class ProducerController {
	
//	@Autowired
//  private KafkaTemplate<String, Object> kafkaTemplate;
	
	@Autowired
	private PersonService personService;

//    private static final String USER_TOPIC = "User_Topic";
    
//    private static final String ADDRESS_TOPIC = "Address_Topic";

//	@GetMapping("/publish/{name}/{technology}/{salary}")
//    public String post(@PathVariable("name") final String name,
//    		@PathVariable("technology") final String technology,
//    		@PathVariable("salary") final String salary) {
//
//        kafkaTemplate.send(USER_TOPIC, 
//        		new User(name, technology, Long.valueOf(salary)));
//
//        return "Published successfully";
//    }
	
	@GetMapping("/person/{pid}")
	public String getPerson(@PathVariable String pid) throws Exception {
		System.out.println("*************************");
		PersonVO personVO = personService.findPerson(
				Integer.valueOf(pid));
		return personVO.toString();
	}
	
	@PostMapping("/person")
	public String savePerson(@RequestBody PersonVO personVO) throws Exception {
		System.out.println("*************************");
		Integer personId = personService.savePerson(personVO);
		return String.valueOf(personId);
	}
	
}
