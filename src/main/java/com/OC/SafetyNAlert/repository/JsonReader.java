package com.OC.SafetyNAlert.repository;

import java.io.File;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.OC.SafetyNAlert.model.JsonFile;
import com.OC.SafetyNAlert.model.Person;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.java.Log;

@Component
@Log
public class JsonReader implements CommandLineRunner{
	/**
	public String readFile() throws StreamReadException, DatabindException, IOException {
		ObjectMapper om = new ObjectMapper();
		File jsonFile = new File("src/main/resources/firestations.json");
		JsonFile jsonData = om.readValue(jsonFile, JsonFile.class);
		jsonData.toString();
		System.out.println("Test inside jsonReader");
		System.out.println(jsonData.getPersons().size());
		String jsonToString = om.writeValueAsString(jsonData);
		
		return jsonToString;
	}
	**/
	
	@Autowired
	private JsonFileRepo jsonFileRepo;
	@Autowired
	private PersonRepository personRepo;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ObjectMapper om = new ObjectMapper();
		//om.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		File jsonFile = new File("src/main/resources/firestations.json");
		JsonFile jsonData = om.readValue(jsonFile, JsonFile.class);
		Person personsData = om.readValue(jsonFile, Person.class);
		JsonFile saveData = jsonFileRepo.save(jsonData);
		Person savePersons = personRepo.saveAndFlush(personsData);
		
		//Map<String, JsonFile> listOfPersons =om.readValue(jsonFile, new TypeReference<Map<String,JsonFile>>(){});

		
		System.out.println(saveData.toString());
		System.out.println(savePersons.toString());


	
}
}