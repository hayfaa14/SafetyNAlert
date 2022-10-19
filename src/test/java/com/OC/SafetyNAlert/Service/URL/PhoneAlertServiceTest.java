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
import com.OC.SafetyNAlert.model.Person;
import com.OC.SafetyNAlert.repository.JsonFileRepo;
import com.OC.SafetyNAlert.service.URL.IPhoneAlertService;
import com.OC.SafetyNAlert.service.URL.PhoneAlertService;


@ExtendWith(MockitoExtension.class)
public class PhoneAlertServiceTest {
	
	@Mock
	JsonFileRepo jsonReader;
	
	@Autowired
	private IPhoneAlertService service;
	
	Map<String,Firestation> firestationMap= new HashMap<>();
	List<Person> persons= new ArrayList<>();
	List<String> expectedPhoneNumbers= new ArrayList<>();
	List<String> phoneNumbersResult = new ArrayList<>();
	
	@Test
	public void testPhoneAlertService() {
		
		firestationMap.put("1", new Firestation("1"));
		firestationMap.get("1").addAddress("street");
		
		Person john = new Person("John","Doe","rue", "London", "0000","0678987654", "johndoe@gmail.com");
		Person jane = new Person("Jane","Doe","street",  "London", "0000","0765689432", "johndoe@gmail.com");
		Person jack = new Person("Jack","Doe","street",  "London", "0000","0654322345", "johndoe@gmail.com");
		
		persons.add(john);
		persons.add(jane);
		persons.add(jack);
		
		expectedPhoneNumbers.add("0765689432");
		expectedPhoneNumbers.add("0654322345");
		
		
		when(jsonReader.readFirestation()).thenReturn(firestationMap);
		when(jsonReader.readPerson()).thenReturn(persons);
		service=new PhoneAlertService(jsonReader);
		phoneNumbersResult=service.getPhoneNumbersByStation("1");
		
		
		assertEquals(expectedPhoneNumbers.toString(),phoneNumbersResult.toString());
	}
	
	

}
