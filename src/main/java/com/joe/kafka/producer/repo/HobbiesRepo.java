package com.joe.kafka.producer.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joe.kafka.producer.entity.Hobbies;

@Repository
public interface HobbiesRepo extends JpaRepository<Hobbies, Integer> {

	Optional<Hobbies> findBypId(Integer id);
	
}
