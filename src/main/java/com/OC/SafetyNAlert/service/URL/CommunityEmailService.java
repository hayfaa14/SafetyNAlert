package com.OC.SafetyNAlert.service.URL;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.OC.SafetyNAlert.model.Person;
import com.OC.SafetyNAlert.repository.JsonFileRepo;

@Service
public class CommunityEmailService implements ICommunityEmailService {
	
	private List<String> emails = new ArrayList<>();
	private List<Person> persons = new ArrayList<>();
	private List<Person> personsByCity = new ArrayList<>();
	
	public CommunityEmailService(JsonFileRepo jsonReader) {
		this.persons=jsonReader.readPerson();
		
	}

	@Override
	public List<String> getCommunityEmail(String city) {
		personsByCity.addAll(persons.stream().filter(p -> p.getCity().matches(city)).collect(Collectors.toList()));   
		personsByCity.forEach(p -> emails.add(p.getEmail()));
		return emails;
	}

}
