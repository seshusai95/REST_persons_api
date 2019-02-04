package com.example.person.detailsAPI.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.example.person.detailsAPI.dao.PersonDAO;
import com.example.person.detailsAPI.model.Person;
import com.example.person.detailsAPI.service.PersonService;
@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	PersonDAO personDAO;
	
	@Override
	public boolean insertIntoPersonDAO(Person person) {
		return personDAO.insertIntoDb(person);
	}

	@Override
	public List<Person> getPersonsFromDAO() {
		// TODO Auto-generated method stub
		return personDAO.getPersonsFromDb();
	}

	@Override
	public Person getPersonFromDAO(int id) {
		
		
		return personDAO.getPersonFromDb(id) ;
	}

	@Override
	public boolean deleteFromDAO(int id) {
		// TODO Auto-generated method stub
		return personDAO.deleteFromDb(id);
	}

	@Override
	public Person putPhoneId(int id, long phone) {
		// TODO Auto-generated method stub
		return personDAO.putPhoneIdDAO(id,phone);
	}

}
