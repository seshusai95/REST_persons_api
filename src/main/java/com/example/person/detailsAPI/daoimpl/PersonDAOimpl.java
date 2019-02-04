package com.example.person.detailsAPI.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.person.detailsAPI.dao.PersonDAO;
import com.example.person.detailsAPI.model.Person;
@Repository
@Transactional
public class PersonDAOimpl implements PersonDAO{

	@PersistenceContext
	EntityManager entityManager;
	
	Logger logger= LoggerFactory.getLogger(PersonDAOimpl.class);
	
	@Override
	public boolean insertIntoDb(Person person) {

		Person person1 ;
		person1=entityManager.merge(person);
		logger.info("this is person object {}", person1);
		if(null!=person1)
		{
			return true;
		}
		else return false;
				
	}

	@Override
	public List<Person> getPersonsFromDb() {

		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("getallpersons", Person.class);
		return namedQuery.getResultList();
	}

	@Override
	public Person getPersonFromDb(int id) {
		Person person2=entityManager.find(Person.class, id);
		logger.info("getting person object with id from DB {}", person2);
		return person2;
	}

	@Override
	public boolean deleteFromDb(int id) {
		Person person=getPersonFromDb(id);
		entityManager.remove(person);
		if((getPersonFromDb(id))!=null)
			return false;
		else
			return true;
	}
	
	@Override
	public Person putPhoneIdDAO(int id,long phone)
	{
		Person person=getPersonFromDb(id);
		person.setPhone(phone);
		if(person!=null)
			return entityManager.merge(person);
		else
			return null;
	}

}
