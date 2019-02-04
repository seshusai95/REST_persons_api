package com.example.person.detailsAPI.service;

import java.util.List;

import com.example.person.detailsAPI.model.Person;



public interface PersonService {
	boolean insertIntoPersonDAO(Person person);
	List<Person> getPersonsFromDAO();
	Person getPersonFromDAO(int id);
	boolean deleteFromDAO(int id);
	Person putPhoneId(int id,long phone);
}
