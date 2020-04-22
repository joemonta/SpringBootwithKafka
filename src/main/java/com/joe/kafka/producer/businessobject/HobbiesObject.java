package com.joe.kafka.producer.businessobject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.joe.kafka.producer.entity.Hobbies;
import com.joe.kafka.producer.repo.HobbiesRepo;
import com.joe.kafka.producer.vo.PersonVO;

@Component
public class HobbiesObject {

	@Autowired
	private HobbiesRepo hobbiesRepo;
	
	public Hobbies findHobbies(Integer pId) {
		return hobbiesRepo.findBypId(pId)
				.orElseThrow();
	}
	
	public void saveHobby(PersonVO personVO) {
		
		Hobbies hobbiesEntity = new Hobbies();
		hobbiesEntity.setName(personVO.getHobbyName());
		hobbiesEntity.setpId(personVO.getpId());
		
		hobbiesRepo.save(hobbiesEntity);
		
		//throw new NullPointerException("Going to throw Null From Hobby Service.");
				
	}
	
}
