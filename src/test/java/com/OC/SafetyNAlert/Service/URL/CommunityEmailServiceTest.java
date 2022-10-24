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

import com.OC.SafetyNAlert.model.Person;
import com.OC.SafetyNAlert.repository.JsonFileRepo;
import com.OC.SafetyNAlert.service.URL.CommunityEmailService;
import com.OC.SafetyNAlert.service.URL.ICommunityEmailService;

@ExtendWith(MockitoExtension.class)
public class CommunityEmailServiceTest {
	
	@Autowired
	private ICommunityEmailService service;
	private List<Person> persons=new ArrayList<>();
	private List<String> expectedEmails= new ArrayList<>();
	
	@Mock
	JsonFileRepo jsonReader;
	
	@Test
	public void getCommunityEmailTest() {
		
		Person john = new Person("John","Doe","rue", "London", "0000","0678987654", "johndoe@gmail.com");
		Person jane = new Person("Jane","Doe","street",  "Manchester", "0000","0765689432", "johndoe@gmail.com");
		Person jack = new Person("Jack","Doe","street",  "London", "0000","0654322345", "jackdoe@gmail.com");
		
		persons.add(john);
		persons.add(jane);
		persons.add(jack);
		
		expectedEmails.add("johndoe@gmail.com");
		expectedEmails.add("jackdoe@gmail.com");
		
		when(jsonReader.readPerson()).thenReturn(persons);
		service= new CommunityEmailService(jsonReader);
		
		assertEquals(expectedEmails,service.getCommunityEmail("London"));
	}

}
