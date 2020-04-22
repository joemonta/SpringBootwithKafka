package com.joe.kafka.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joe.kafka.producer.businessobject.AddressObject;
import com.joe.kafka.producer.businessobject.HobbiesObject;
import com.joe.kafka.producer.businessobject.PersonObject;
import com.joe.kafka.producer.entity.Person;
import com.joe.kafka.producer.vo.PersonVO;

@Service
public class PersonService {

	@Autowired
	public PersonObject personObject;
	
	@Autowired
	public AddressObject addressObject;
	
	@Autowired
	public HobbiesObject hobbiesObject;
	
	public PersonVO findPerson(Integer pId) throws Exception {
		Person person = personObject.findPerson(pId);
		//Address address = addressObject.findAddress(pId);
		
		PersonVO personVO = new PersonVO();
		personVO.setAge(person.getAge());
		//personVO.setCity(address.getCity());
		//personVO.setCountry(address.getCountry());
		personVO.setFirstName(person.getFirstName());
		personVO.setLastName(person.getLastName());
		
		return personVO;
	}
	
	@Transactional(rollbackFor = NullPointerException.class)
	public Integer savePerson(PersonVO personVO) throws Exception {
		
		try {
			
			Integer pId = personObject.savePerson(personVO);
			
			personVO.setpId(pId);
			
			addressObject.saveAddress(personVO);
			
			hobbiesObject.saveHobby(personVO);
			
		} catch(Exception e) {
			
			addressObject.removeAddress(personVO);
			
			throw e;
		}
		
		return personVO.getpId();
	}
	
}
