package com.OC.SafetyNAlert.service;

import com.OC.SafetyNAlert.model.JsonFile;
import com.OC.SafetyNAlert.model.Person;

public interface IJsonFileService {
	
	public Iterable<JsonFile> getJsonFile();

	public Person savePerson(Person person );

}
