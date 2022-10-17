package com.OC.SafetyNAlert.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.OC.SafetyNAlert.Shared.Result;
import com.OC.SafetyNAlert.model.Person;
import com.OC.SafetyNAlert.service.IPersonService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class PersonController {
	
	@Autowired
	private IPersonService personService;
	
	@ResponseBody
	@GetMapping("/person")
	public Iterable<Person> getPersons() throws IOException,JsonProcessingException{
		return personService.getPersons();
	}
	
	@PostMapping("/person/add")
	public Person createPerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}
	@PutMapping("/person/{firstName}/{lastName}")
    public Result updatePerson(@RequestBody Person personDetails,@PathVariable String firstName,@PathVariable String lastName) {
		Result updatedPerson = personService.updatePerson(personDetails, firstName, lastName);
        return updatedPerson;
    }
	
	@RequestMapping(value = "person/delete/{firstName}/{lastName}",method=RequestMethod.DELETE)
	public Result deletePerson(@PathVariable String firstName, @PathVariable String lastName) {
		Result deletedPerson = personService.deletePerson(firstName,lastName);
			return deletedPerson;
		}
	}

