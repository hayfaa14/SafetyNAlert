package com.OC.SafetyNAlert.Service.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.OC.SafetyNAlert.model.Medicalrecord;
import com.OC.SafetyNAlert.model.Person;
import com.OC.SafetyNAlert.service.URL.SharedMethods;


public class SharedMethodsTest {
	
	@Autowired
	SharedMethods sm=new SharedMethods();
	
	 List<Person> persons= new ArrayList<>();
	 List<Medicalrecord> medRecords = new ArrayList<>();
	
	@BeforeEach
	public void setUp() {
		
		 Person john = new Person("John","Doe","rue", "123456", "London", "0000", "johndoe@gmail.com");
		 Person jane = new Person("Jane","Doe","street", "123456", "London", "0000", "johndoe@gmail.com");
		 medRecords.add(new Medicalrecord(john.getFirstName(),john.getLastName(), "03/13/1993", "iodine", "peanut"));
		 medRecords.add(new Medicalrecord(jane.getFirstName(),jane.getLastName(), "03/14/1994", "iodine", "peanut"));
		 
		 persons.add(john);
		 persons.add(jane);

	}
	
	@Test
	public void setMedicalRecordTest() {
			sm.setMedicalrecords(persons,medRecords);
			assertEquals(medRecords.get(0),persons.get(0).getMedicalRecord());
	}

	@Test
	public void calculateAgeTest() {
		sm.setMedicalrecords(persons,medRecords);
		sm.calculateAge(persons);
		assertEquals(29,persons.get(0).getAge());

		
		
	}

}
