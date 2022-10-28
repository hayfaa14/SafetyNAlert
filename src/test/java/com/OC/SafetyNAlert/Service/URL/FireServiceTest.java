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
import com.OC.SafetyNAlert.service.URL.FireService;
import com.OC.SafetyNAlert.service.URL.IFireService;

import DTO.FireResult;
import DTO.PersonInfo;
import DTO.Resident;

@ExtendWith(MockitoExtension.class)
public class FireServiceTest {

	@Autowired
	private IFireService service;
	
	FireResult expectedResult;
	
	@Mock
	JsonFileRepo jsonReader;
	
	
	
	@Test
	public void getResidentsByAddressTest() {
		Map<String,Firestation> firestationMap= new HashMap<>();
		List<Person> persons= new ArrayList<>();
		List<Medicalrecord> medRecords = new ArrayList<>();
		List<Resident> expectedResidents = new ArrayList<>();
		
		FireResult testResult;
		FireResult expectedResult;
		
		firestationMap.put("1", new Firestation("1"));
		firestationMap.get("1").addAddress("street");
		
		Person john = new Person("John","Doe","rue", "123456", "London", "0000", "johndoe@gmail.com");
		Person jane = new Person("Jane","Doe","street", "123456", "London", "0000", "johndoe@gmail.com");
		Person jack = new Person("Jack","Doe","street", "123456", "London", "0000", "johndoe@gmail.com");
		Person jason = new Person("Jason","Doe","road", "123456", "London", "0000", "johndoe@gmail.com");
		
		medRecords.add(new Medicalrecord(john.getFirstName(),john.getLastName(), "03/13/1993", "iodine", "peanut"));
		medRecords.add(new Medicalrecord(jane.getFirstName(),jane.getLastName(), "03/14/1994", "iodine", "peanut"));
		medRecords.add(new Medicalrecord(jack.getFirstName(),jack.getLastName(), "09/16/2018", "iodine", "peanut"));
		medRecords.add(new Medicalrecord(jason.getFirstName(),jason.getLastName(), "05/19/1999", "iodine", "peanut"));
		
		john.setMedicalRecord(medRecords.get(0));
		jane.setMedicalRecord(medRecords.get(1));
		jack.setMedicalRecord(medRecords.get(2));
		jason.setMedicalRecord(medRecords.get(3));
		
		john.calculateAge();
		jane.calculateAge();
		jack.calculateAge();
		jason.calculateAge();
		
		persons.add(john);
		persons.add(jane);
		persons.add(jack);
		persons.add(jason);
		
		
		expectedResidents.add(new Resident(jane.getFirstName(),jane.getLastName(),jane.getAge(),jane.getPhone(),jane.getMedicalRecord()));
		expectedResidents.add(new Resident(jack.getFirstName(),jack.getLastName(),jack.getAge(),jack.getPhone(),jack.getMedicalRecord()));
		
		
		when(jsonReader.readPerson()).thenReturn(persons);
		when(jsonReader.readFirestation()).thenReturn(firestationMap);
		when(jsonReader.readMedicalrecord()).thenReturn(medRecords);
		
		service = new FireService(jsonReader);
		expectedResult = new FireResult("1",expectedResidents);
		testResult=service.getResidentsByAddress("street");
		assertEquals(expectedResult.getResidents().toString(),testResult.getResidents().toString());
		assertEquals(expectedResult.getStation(),testResult.getStation());

		
	
	}
	
	
}
