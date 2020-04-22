package com.joe.kafka.producer.businessobject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.joe.kafka.producer.entity.Address;
import com.joe.kafka.producer.vo.PersonVO;

@Component
public class AddressObject {
	
	@Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
	
	private static final String ADDRESS_TOPIC = "Address_Topic";
	
	private static final String TO_REMOVE_ADDRESS_TOPIC = "Remove_Address_Topic";
	
//	public Address findAddress(Integer pId) throws Exception {
//		
//		final String baseUrl = "http://localhost:3333/getaddress/"+pId;
//	    URI uri = new URI(baseUrl);
//	    
//	    ResponseEntity<Address> address = 
//	    		restTemplate.getForEntity(uri, Address.class);
//		
//		return address.getBody();
//	}

	public void saveAddress(PersonVO personVO) throws Exception {
		
		Address addressEntity = new Address();
		addressEntity.setpId(personVO.getpId());
		addressEntity.setCity(personVO.getCity());
		addressEntity.setCountry(personVO.getCountry());
		
		kafkaTemplate.send(ADDRESS_TOPIC, 
				addressEntity);
		
        System.out.println("Address Published Successfully");
		
	}
	
	public Integer removeAddress(PersonVO personVO) throws Exception {
		
		Address addressEntity = new Address();
		addressEntity.setpId(personVO.getpId());
		
		kafkaTemplate.send(TO_REMOVE_ADDRESS_TOPIC, addressEntity);
		
		System.out.println("Published to Remove Address");
			    
	    return 1;
	}
}
