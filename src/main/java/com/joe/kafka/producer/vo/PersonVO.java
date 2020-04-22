package com.joe.kafka.producer.vo;

public class PersonVO {
	
	public Integer pId;

	public String firstName;
	
	public String lastName;
	
	public Integer age;
	
	public String city;
	
	public String country;
	
	public String hobbyName;
	
	public Integer phNo;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHobbyName() {
		return hobbyName;
	}

	public void setHobbyName(String hobbyName) {
		this.hobbyName = hobbyName;
	}

	public Integer getPhNo() {
		return phNo;
	}

	public void setPhNo(Integer phNo) {
		this.phNo = phNo;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	@Override
	public String toString() {
		return "PersonVO [pId=" + pId + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", city=" + city + ", country=" + country + ", hobbyName=" + hobbyName + ", phNo=" + phNo + "]";
	}
		
}
