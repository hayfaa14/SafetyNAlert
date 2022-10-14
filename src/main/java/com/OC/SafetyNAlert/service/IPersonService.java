package com.OC.SafetyNAlert.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OC.SafetyNAlert.Shared.Result;
import com.OC.SafetyNAlert.model.Person;
@Service
public interface IPersonService {
	
	 List<Person> getPersons();
	
	 Person savePerson(Person person);
		
	 Result updatePerson(Person person, String firstName, String lastName);

	 Result deletePerson(String firstName, String lastName); 	

}
