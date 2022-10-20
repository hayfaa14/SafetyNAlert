package com.OC.SafetyNAlert.service.URL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OC.SafetyNAlert.model.Firestation;
import com.OC.SafetyNAlert.model.Medicalrecord;
import com.OC.SafetyNAlert.model.Person;
import com.OC.SafetyNAlert.repository.JsonFileRepo;


import DTO.HouseholdMember;

@Service
public class FloodService implements IFloodService {
	
	
	
	@Autowired
	JsonFileRepo jsonReader;
	
	private List<Person> persons=new ArrayList<>();
	private Map<String,Firestation> firestationMap=new HashMap<>();
	private List<Medicalrecord> medRecords = new ArrayList<>();

	
	private List<String> addressesByStation=new ArrayList<>();
	private HashMap<String,List<HouseholdMember>> householdMap = new HashMap<>();
	private List<HouseholdMember> householdMembers=new ArrayList<>();
	
	
	public FloodService(JsonFileRepo jsonReader) {
		this.persons=jsonReader.readPerson();
		this.firestationMap=jsonReader.readFirestation();
		this.medRecords=jsonReader.readMedicalrecord();
	}
	
	public void setMedicalrecords() {
		for(int i=0;i<persons.size();i++) {
			persons.get(i).setMedicalRecord(medRecords.get(i));
		}
		
	}

	@Override
	public HashMap<String, List<HouseholdMember>> getHouseholds(String station) {
		//System.out.println(persons);
		setMedicalrecords();
		//System.out.println(persons);
		persons.forEach(p -> householdMembers.add(new HouseholdMember(p.getFirstName(),p.getLastName(),p.getPhone(),p.getAge(),p.getMedicalRecord(),p.getAddress())));

		addressesByStation.addAll(firestationMap.get(station).getAddresses());
		addressesByStation.forEach(ad -> 					
			householdMap.put(ad, householdMembers.stream().filter(p -> p.getAddress().equals(ad)).collect(Collectors.toList())));
			//System.out.println(householdMap);
			//System.out.println(householdMap);
			
		// TODO Auto-generated method stub
		return householdMap;
	}

}
