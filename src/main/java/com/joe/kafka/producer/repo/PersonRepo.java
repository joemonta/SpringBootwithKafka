package com.joe.kafka.producer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joe.kafka.producer.entity.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

}
