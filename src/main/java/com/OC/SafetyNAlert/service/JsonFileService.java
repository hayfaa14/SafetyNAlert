package com.OC.SafetyNAlert.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.OC.SafetyNAlert.model.JsonFile;
import com.OC.SafetyNAlert.model.Person;
import com.OC.SafetyNAlert.repository.JsonFileRepo;

@Service
public class JsonFileService implements IJsonFileService{
	
	@Autowired
	private JsonFileRepo jsonFileRepo;
	
	public Iterable<JsonFile> getJsonFile(){
		return jsonFileRepo.findAll();
	}

	public Person savePerson(Person person ) {
		Person savedPerson = jsonFileRepo.save(person);
		return savedPerson;
	}

}
