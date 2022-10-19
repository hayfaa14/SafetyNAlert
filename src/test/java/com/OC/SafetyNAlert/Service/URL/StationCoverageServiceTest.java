package com.OC.SafetyNAlert.Service.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.OC.SafetyNAlert.model.Firestation;
import com.OC.SafetyNAlert.model.Medicalrecord;
import com.OC.SafetyNAlert.model.Person;
import com.OC.SafetyNAlert.repository.JsonFileRepo;
import com.OC.SafetyNAlert.service.URL.IStationCoverageService;
import com.OC.SafetyNAlert.service.URL.StationCoverageService;

import DTO.PersonCovered;
import DTO.PersonsCoveredResult;

@ExtendWith(MockitoExtension.class)
public class StationCoverageServiceTest {
	
	@Mock
	private JsonFileRepo jsonReader;
	
	@Autowired
	IStationCoverageService service;
	Long expectedNChildren=(long) 1;
	Long expectedNAdults=(long) 2;
	
	@Autowired
	PersonsCoveredResult expectedResult;
	@Test
	public void testGetStationCoverage() {
		
		Map<String,Firestation> firestationMap= new HashMap<>();
		List<Person> persons= new ArrayList<>();
		List<Medicalrecord> medRecords = new ArrayList<>();
		List<PersonCovered> ExpectedPersonsCovered = new ArrayList<>();

		firestationMap.put("1", new Firestation("1"));
		firestationMap.get("1").addAddress("street");
		HashMap<String,Long> nAdultsChildren = new HashMap<>();
		nAdultsChildren.put("Adults", expectedNAdults);
		nAdultsChildren.put("Children", expectedNChildren);
		
		Person john = new Person("John","Doe","rue", "123456", "London", "0000", "johndoe@gmail.com");
		Person jane = new Person("Jane","Doe","street", "123456", "London", "0000", "johndoe@gmail.com");
		Person jack = new Person("Jack","Doe","street", "123456", "London", "0000", "johndoe@gmail.com");
		Person jason = new Person("Jason","Doe","street", "123456", "London", "0000", "johndoe@gmail.com");
		
		medRecords.add(new Medicalrecord(john.getFirstName(),john.getLastName(), "03/13/1993", "iodine", "peanut"));
		medRecords.add(new Medicalrecord(jane.getFirstName(),jane.getLastName(), "03/14/1994", "iodine", "peanut"));
		medRecords.add(new Medicalrecord(jack.getFirstName(),jack.getLastName(), "09/16/2018", "iodine", "peanut"));
		medRecords.add(new Medicalrecord(jason.getFirstName(),jason.getLastName(), "05/19/1999", "iodine", "peanut"));
		
		persons.add(john);
		persons.add(jane);
		persons.add(jack);
		persons.add(jason);
		
		ExpectedPersonsCovered.add(new PersonCovered(jane.getFirstName(),jane.getLastName(),jane.getAddress(),jane.getPhone()));
		ExpectedPersonsCovered.add(new PersonCovered(jack.getFirstName(),jack.getLastName(),jack.getAddress(),jack.getPhone()));
		ExpectedPersonsCovered.add(new PersonCovered(jason.getFirstName(),jason.getLastName(),jason.getAddress(),jason.getPhone()));

		when(jsonReader.readFirestation()).thenReturn(firestationMap);
		when(jsonReader.readPerson()).thenReturn(persons);
		when(jsonReader.readMedicalrecord()).thenReturn(medRecords);
		
		service=new StationCoverageService(jsonReader);
		PersonsCoveredResult testResult=service.getStationCoverage("1");
		expectedResult= new PersonsCoveredResult(ExpectedPersonsCovered,nAdultsChildren);
		
		//testing the number of children and/or adults covered by the station
		assertEquals(expectedResult,testResult);
		//assert comparing two hashmaps failing even though result is the same
	}
	
	

}
