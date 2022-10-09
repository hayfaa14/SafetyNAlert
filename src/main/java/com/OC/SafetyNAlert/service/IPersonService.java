package com.OC.SafetyNAlert.service;

import java.util.List;

import com.OC.SafetyNAlert.Shared.Result;
import com.OC.SafetyNAlert.model.Person;

public interface IPersonService {
	
	public List<Person> getPersonList();
	
	public Iterable<Person> getPersons();
	
	public Person addPerson(Person person);
		
	public Result updatePerson(Person person, String firstName, String lastName);

	public Result deletePerson(String firstName, String lastName); 	

}
