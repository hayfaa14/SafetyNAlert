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
import com.OC.SafetyNAlert.service.URL.FloodService;
import com.OC.SafetyNAlert.service.URL.IFloodService;

import DTO.HouseholdMember;

@ExtendWith(MockitoExtension.class)
public class FloodServiceTest {
	
	@Autowired
	IFloodService service;
	
	@Mock
	JsonFileRepo jsonReader;
	
	@Test
	public void testGetHouseholds() {
		 List<Person> persons=new ArrayList<>();
		 Map<String,Firestation> firestationMap=new HashMap<>();
		 List<Medicalrecord> medRecords = new ArrayList<>();
		 HashMap<String,List<HouseholdMember>> expectedHouseholdMembersMap = new HashMap<>();
		 List<HouseholdMember> expectedHouseholdMembersList= new ArrayList<>();
		 
		 
		 	firestationMap.put("1", new Firestation("1"));
			firestationMap.get("1").addAddress("street");
			
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
			
			expectedHouseholdMembersList.add(new HouseholdMember(jane.getFirstName(),jane.getLastName(),jane.getPhone(),jane.getAge(),jane.getMedicalRecord(),jane.getAddress()));
			expectedHouseholdMembersList.add(new HouseholdMember(jack.getFirstName(),jack.getLastName(),jack.getPhone(),jack.getAge(),jack.getMedicalRecord(),jack.getAddress()));
			expectedHouseholdMembersList.add(new HouseholdMember(jason.getFirstName(),jason.getLastName(),jason.getPhone(),jason.getAge(),jason.getMedicalRecord(),jason.getAddress()));

			expectedHouseholdMembersMap.put("street", expectedHouseholdMembersList);
						
		 when(jsonReader.readFirestation()).thenReturn(firestationMap);
		 when(jsonReader.readPerson()).thenReturn(persons);
		 when(jsonReader.readMedicalrecord()).thenReturn(medRecords);
		 
		 
		 
		 service = new FloodService(jsonReader);
		 assertEquals(expectedHouseholdMembersMap.toString(),service.getHouseholds("1").toString());
	}
	

}
