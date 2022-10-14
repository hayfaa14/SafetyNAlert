package com.OC.SafetyNAlert.repository;

import java.util.List;
import java.util.Map;

import com.OC.SafetyNAlert.model.Firestation;
import com.OC.SafetyNAlert.model.Person;

public interface JsonFileRepo {

	List<Person> readPerson();
	Map<String, Firestation> readFirestation();
	


}
