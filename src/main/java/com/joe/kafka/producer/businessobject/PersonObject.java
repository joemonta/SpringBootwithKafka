package com.joe.kafka.producer.businessobject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.joe.kafka.producer.entity.Person;
import com.joe.kafka.producer.repo.PersonRepo;
import com.joe.kafka.producer.vo.PersonVO;

@Component
public class PersonObject {

	@Autowired
	private PersonRepo personRepo;
	
	public Person findPerson(Integer pId) {
		return personRepo.findById(pId)
				.orElseThrow();
	}
	
	public Integer savePerson(PersonVO personVO) {
		
		Person personEntity = new Person();
		personEntity.setFirstName(personVO.getFirstName());
		personEntity.setLastName(personVO.getLastName());
		personEntity.setAge(personVO.getAge());
		
		return personRepo.save(personEntity)
				.getId();
	}
	
}
