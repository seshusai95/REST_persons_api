package com.example.person.detailsAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.person.detailsAPI.model.Person;
import com.example.person.detailsAPI.service.PersonService;

@RestController
@CrossOrigin
public class PersonController {
@Autowired
PersonService personService;

@PostMapping("/persons")
public HttpStatus insertPerson(@RequestBody Person person)
{
	boolean status=personService.insertIntoPersonDAO(person);
	if(status==true)
	{
		return HttpStatus.CREATED;				
	}
	else return HttpStatus.BAD_REQUEST;			
}

@GetMapping("/persons/{id}")
public Person getPerson(@PathVariable int id)
{	
	ResponseEntity<Person> responseEntity=new ResponseEntity<Person>( personService.getPersonFromDAO(id), HttpStatus.OK);	
	return responseEntity.getBody();
}
@GetMapping("/persons")
public List<Person> getAllPersons()
{	
	return personService.getPersonsFromDAO();
}

@DeleteMapping("/persons/{id}")
public HttpStatus deletePersonById(@PathVariable int id)
{
	boolean status=personService.deleteFromDAO(id);
	if(status==true)
		return HttpStatus.OK;
	else
		return HttpStatus.CONFLICT;
}

@PatchMapping("/persons/{id}/{phone}")
public Person putPhonebyId(@PathVariable int id,@PathVariable long phone)
{
		return personService.putPhoneId(id, phone);
}
}
