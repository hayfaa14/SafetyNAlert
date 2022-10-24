package com.OC.SafetyNAlert.service.URL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.OC.SafetyNAlert.model.Firestation;
import com.OC.SafetyNAlert.model.Person;
import com.OC.SafetyNAlert.repository.JsonFileRepo;


@Service
public class PhoneAlertService implements IPhoneAlertService{
	
	List<Person> persons= new ArrayList<>();
	Map<String,Firestation> firestationMap= new HashMap<>();
	List<String> phoneNumbers = new ArrayList<>();
	List<String> addressesPerStation = new ArrayList<>();
	List<Person> personsPerAddress=new ArrayList<>();
	
	public PhoneAlertService(JsonFileRepo jsonReader){
		this.persons=jsonReader.readPerson();
		this.firestationMap=jsonReader.readFirestation();
	}
	
	public List<String> getPhoneNumbersByStation(String station){
		
		addressesPerStation.addAll(firestationMap.get(station).getAddresses());
		
		addressesPerStation.forEach(
				
				ad -> personsPerAddress.addAll(persons.stream().filter(p -> 
				
						p.getAddress().equals(ad)).collect(Collectors.toList()))
				);
		personsPerAddress.forEach(p -> phoneNumbers.add(p.getPhone()));		
		return phoneNumbers;
	}
	
	
	

}
