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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "This is Person API Controller")
@RestController
@CrossOrigin
public class PersonController {
@Autowired
PersonService personService;

@ApiOperation(value = "Inserts a Person into DB", notes ="You can use this API endpoint to insert the Person into Database given his details. It returns HTTPStatus")
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

@ApiOperation(value = "Gets details of a Person", notes ="You can use this API endpoint to get the details of a Person using his Id. It returns a Person Object")
@GetMapping("/persons/{id}")
public Person getPerson(@PathVariable int id)
{	
	ResponseEntity<Person> responseEntity=new ResponseEntity<Person>( personService.getPersonFromDAO(id), HttpStatus.OK);	
	return responseEntity.getBody();
}

@ApiOperation(value = "It gets a List of Persons", notes ="You can use this API endpoint to get all the Persons present in the DB. It returns a List of Persons")
@GetMapping("/persons")
public List<Person> getAllPersons()
{	
	return personService.getPersonsFromDAO();
}

@ApiOperation(value = "Deletes a Person from DB", notes ="You can use this API endpoint to delete a peroson from DataBase given his userId. It returns HTTP Status")
@DeleteMapping("/persons/{id}")
public HttpStatus deletePersonById(@PathVariable int id)
{
	boolean status=personService.deleteFromDAO(id);
	if(status==true)
		return HttpStatus.OK;
	else
		return HttpStatus.CONFLICT;
}

@ApiOperation(value = "Updates Person details", notes ="You can use this API endpoint to update a Person PhoneNumber using his Id and new PhoneNumber. It returns Person Object")
@PatchMapping("/persons/{id}/{phone}")
public Person putPhonebyId(@PathVariable int id,@PathVariable long phone)
{
		return personService.putPhoneId(id, phone);
}
}
