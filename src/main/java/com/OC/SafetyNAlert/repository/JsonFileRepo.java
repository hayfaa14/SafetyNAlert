package com.OC.SafetyNAlert.repository;

import java.util.List;
import com.OC.SafetyNAlert.model.Person;

public interface JsonFileRepo  {

	List<Person> readPerson();

}
