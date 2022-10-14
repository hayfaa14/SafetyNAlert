package com.OC.SafetyNAlert.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OC.SafetyNAlert.Shared.Result;
import com.OC.SafetyNAlert.model.Person;
import com.OC.SafetyNAlert.repository.JsonFileRepo;



@Service
public class PersonService implements IPersonService {
	
	@Autowired
	private JsonFileRepo reader;
	
	private List<Person> listOfPersons;

	public PersonService(JsonFileRepo reader){
		this.listOfPersons=reader.readPerson();
	}

	
	public List<Person> getPersons(){
		return this.listOfPersons;
	}

	public Person savePerson(Person person) {		
		this.listOfPersons.add(person);
		 return person;
	}

	public Result updatePerson(Person person, String firstName, String lastName) {
		for(Person updatePerson:listOfPersons) {
			if(person.getFirstName()==firstName && person.getLastName()==lastName) {
				int indexOfPersonToUpdate=listOfPersons.indexOf(updatePerson);
				listOfPersons.set(indexOfPersonToUpdate, person);
				return Result.success;
				
			}
		}
		return Result.failure;
	}

	public Result deletePerson(String firstName, String lastName) {
		for(Person person:listOfPersons) {
			if(person.getFirstName()==firstName && person.getLastName()==lastName) {
				listOfPersons.remove(person);
				return Result.success;
			}
		}
		return Result.failure;
	}	

}
