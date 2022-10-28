package com.OC.SafetyNAlert.Service.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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
import com.OC.SafetyNAlert.service.URL.IPersonInfoService;
import com.OC.SafetyNAlert.service.URL.PersonInfoService;

import DTO.PersonInfo;

@ExtendWith(MockitoExtension.class)
public class PersonInfoServiceTest {
	
	@Mock
	JsonFileRepo jsonReader;
	
	@Autowired
	IPersonInfoService service;
	

	
	@Test
	public void testGetPersonInfo() {
		 List<Person> persons= new ArrayList<>();
		 List<PersonInfo> expectedPersonsInfo = new ArrayList<>();
		 List<PersonInfo> testResultPersonInfo = new ArrayList<>();
		 List<Medicalrecord> medRecords = new ArrayList<>();
		
		Person john = new Person("John","Doe","rue", "123456", "London", "0000", "johndoe@gmail.com");
		Person jane = new Person("Jane","Doe","street", "123456", "London", "0000", "johndoe@gmail.com");
		Person jack = new Person("Jack","Doe","street", "123456", "London", "0000", "johndoe@gmail.com");
		Person jason = new Person("Jason","Doe","street", "123456", "London", "0000", "johndoe@gmail.com");
		Person jason2 = new Person("Jason","Doe","quartier", "123456", "London", "1111", "johndoe2@gmail.com");
		
		
		medRecords.add(new Medicalrecord(john.getFirstName(),john.getLastName(), "03/13/1993", "iodine", "peanut"));
		medRecords.add(new Medicalrecord(jane.getFirstName(),jane.getLastName(), "03/14/1994", "iodine", "peanut"));
		medRecords.add(new Medicalrecord(jack.getFirstName(),jack.getLastName(), "09/16/2018", "iodine", "peanut"));
		medRecords.add(new Medicalrecord(jason.getFirstName(),jason.getLastName(), "05/19/1999", "iodine", "peanut"));
		medRecords.add(new Medicalrecord(jason2.getFirstName(),jason2.getLastName(), "07/11/1991", "hydroxiclhoroquine", "prawn"));
		
		john.setMedicalRecord(medRecords.get(0));
		jane.setMedicalRecord(medRecords.get(1));
		jack.setMedicalRecord(medRecords.get(2));
		jason.setMedicalRecord(medRecords.get(3));
		jason2.setMedicalRecord(medRecords.get(4));
		
		john.calculateAge();
		jane.calculateAge();
		jack.calculateAge();
		jason.calculateAge();
		jason2.calculateAge();
		
		
		persons.add(john);
		persons.add(jane);
		persons.add(jack);
		persons.add(jason);
		persons.add(jason2);
		
		
		
		expectedPersonsInfo.add(new PersonInfo(jason.getFirstName(),jason.getLastName(),jason.getAddress(),jason.getAge(),
				jason.getEmail(),jason.getMedicalRecord()));
		expectedPersonsInfo.add(new PersonInfo(jason2.getFirstName(),jason2.getLastName(),jason2.getAddress(),jason2.getAge(),
				jason2.getEmail(),jason2.getMedicalRecord()));
		
		when(jsonReader.readPerson()).thenReturn(persons);
		when(jsonReader.readMedicalrecord()).thenReturn(medRecords);
		
		service = new PersonInfoService(jsonReader);
		
		testResultPersonInfo=service.getPersonInfo("Jason", "Doe");
		System.out.println(expectedPersonsInfo);
		assertEquals(expectedPersonsInfo.toString(),testResultPersonInfo.toString());
		
	}

}
