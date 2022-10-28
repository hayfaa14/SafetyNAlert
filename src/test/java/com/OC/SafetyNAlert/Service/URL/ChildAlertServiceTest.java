package com.OC.SafetyNAlert.Service.URL;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.OC.SafetyNAlert.model.Medicalrecord;
import com.OC.SafetyNAlert.model.Person;
import com.OC.SafetyNAlert.repository.JsonFileRepo;
import com.OC.SafetyNAlert.service.URL.ChildAlertService;
import com.OC.SafetyNAlert.service.URL.IChildAlertService;

import DTO.Adult;
import DTO.Child;

@ExtendWith(MockitoExtension.class)
public class ChildAlertServiceTest {
	
	@Mock
	JsonFileRepo jsonReader;
	
	@Autowired
	private IChildAlertService childService;
	
	List<Person> persons = new ArrayList<>();
	List<Medicalrecord> medRecords = new ArrayList<>();
	List<Adult> familymembers = new ArrayList<>();
	
	@Test
	public void testGetChildAlert() throws ParseException {
		
		Person john = new Person("John","Doe","street", "123456", "London", "0000", "johndoe@gmail.com");
		Person jane = new Person("Jane","Doe","street", "123456", "London", "0000", "johndoe@gmail.com");
		Person jack = new Person("Jack","Doe","street", "123456", "London", "0000", "johndoe@gmail.com");
		
		persons.add(john);
		persons.add(jane);
		persons.add(jack);
		
		familymembers.add(new Adult(john.getFirstName(),john.getLastName()));
		familymembers.add(new Adult(jane.getFirstName(),jane.getLastName()));
		
		medRecords.add(new Medicalrecord(john.getFirstName(),john.getLastName(), "03/13/1993", "iodine", "peanut"));
		medRecords.add(new Medicalrecord(jane.getFirstName(),jane.getLastName(), "03/14/1994", "iodine", "peanut"));
		medRecords.add(new Medicalrecord(jack.getFirstName(),jack.getLastName(), "09/16/2018", "iodine", "peanut"));
		
		john.setMedicalRecord(medRecords.get(0));
		jane.setMedicalRecord(medRecords.get(1));
		jack.setMedicalRecord(medRecords.get(2));
		
		john.calculateAge();
		jane.calculateAge();
		jack.calculateAge();
		
		when(jsonReader.readPerson()).thenReturn(persons);
		when(jsonReader.readMedicalrecord()).thenReturn(medRecords);
		List<Child> expectedChildrenByAddress = new ArrayList<>();
		expectedChildrenByAddress.add(new Child(jack.getFirstName(),jack.getLastName(),jack.getAge(),familymembers));
		childService = new ChildAlertService(jsonReader);
		List<Child> testResult=childService.getChildAlert("street");
		assertEquals(expectedChildrenByAddress.toString(),testResult.toString());

		
		
	}

}
