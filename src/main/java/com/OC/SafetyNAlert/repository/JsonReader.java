package com.OC.SafetyNAlert.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import com.OC.SafetyNAlert.model.Firestation;
import com.OC.SafetyNAlert.model.Person;
import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JsonReader implements JsonFileRepo{

			
		 String filePath = "src/main/resources/firestations.json";
		    byte[] bytesFile = Files.readAllBytes(new File(filePath).toPath());
		    JsonIterator iter = JsonIterator.parse(bytesFile);
		    Any any = iter.readAny();

		    public JsonReader() throws IOException {
		    }

		    public List<Person> readPerson() {
		        Any personAny = any.get("persons");
		        List<Person> persons = new ArrayList<>();
		        for (Any person : personAny) {
		            persons.add(new Person(person.get("firstName").toString(), person.get("lastName").toString(), person.get("address").toString(), person.get("city").toString(),
		                    person.get("zip").toString(), person.get("phone").toString(), person.get("email").toString()));
		        }
		        return persons;
		    }
		    /*
		    public Map<String,Firestation> readFirestation(){
		    	Any firestationAny = any.get("firestations");
		        Map<String, Firestation> firestations = new HashMap<>();
		        firestationAny.forEach(station -> firestations.compute(station.get("station").toString(),
		                (k, v) -> v == null ?
		                        new Firestation(station.get("station").toString()).setAddresses(station.get("address").toString()) :
		                        v.setAddresses(station.get("address").toString())));
		        return firestations;
		    }
		    */
		    
		    public Map<String, Firestation> readFirestation() {
		        Any fireStationAny = any.get("firestations");
		        Map<String, Firestation> fireStations = new HashMap<>();
		        fireStationAny.forEach(station -> fireStations.compute(station.get("station").toString(),
		                (k, v) -> v == null ?
		                        new Firestation(station.get("station").toString()).addAddress(station.get("address").toString()) :
		                        v.addAddress(station.get("address").toString())));
		        return fireStations;
		    }

}