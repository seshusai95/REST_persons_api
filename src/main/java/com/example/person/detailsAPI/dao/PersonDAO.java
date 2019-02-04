package com.example.person.detailsAPI.dao;

import java.util.List;



import com.example.person.detailsAPI.model.Person;

public interface PersonDAO {
boolean insertIntoDb(Person person);
List<Person> getPersonsFromDb();
Person getPersonFromDb(int id);
boolean deleteFromDb(int id);
Person putPhoneIdDAO(int id, long phone);
}
