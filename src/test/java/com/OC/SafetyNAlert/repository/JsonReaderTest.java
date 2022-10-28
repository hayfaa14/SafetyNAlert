package com.OC.SafetyNAlert.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.OC.SafetyNAlert.model.Firestation;
import com.OC.SafetyNAlert.model.Medicalrecord;
import com.OC.SafetyNAlert.model.Person;

public class JsonReaderTest {
	
	List<Person> persons;
	List<Medicalrecord> medRecords;
	Map<String, Firestation> firestations;
	
	@Test
	public void testReadPerson() throws IOException{
		persons = new JsonReader().readPerson();
		assertEquals(Boolean.FALSE,persons.isEmpty());
		
	}
	
	@Test
	public void testReadMedicalRecord() throws IOException{
		medRecords = new JsonReader().readMedicalrecord();
		assertEquals(Boolean.FALSE,medRecords.isEmpty());
		
	}
	
	@Test
	public void testReadFirestation() throws IOException{
		firestations = new JsonReader().readFirestation();
		assertEquals(Boolean.FALSE,firestations.isEmpty());
		
	}
	
}
