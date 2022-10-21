package com.OC.SafetyNAlert.service.URL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.OC.SafetyNAlert.model.Firestation;
import com.OC.SafetyNAlert.model.Medicalrecord;
import com.OC.SafetyNAlert.model.Person;
import com.OC.SafetyNAlert.repository.JsonFileRepo;

import DTO.FireResult;
import DTO.Resident;


@Service
public class FireService implements IFireService {
	
	
	FireResult result;
	
	private List<Person> persons= new ArrayList<>();
	private Map<String,Firestation> firestationMap= new HashMap<>();
	private List<Resident> residents =  new ArrayList<>();
	private List<Person> personsByAddress=new ArrayList<>();
	private String station;

	private List<Medicalrecord> medRecords=new ArrayList<>();
	
	public FireService(JsonFileRepo jsonReader) {
		this.persons=jsonReader.readPerson();
		this.firestationMap=jsonReader.readFirestation();
		this.medRecords=jsonReader.readMedicalrecord();
		
	}

	public void setMedicalrecords() {
		for(int i=0;i<persons.size();i++) {
			persons.get(i).setMedicalRecord(medRecords.get(i));
		}
		
	}
	public FireResult getResidentsByAddress(String address) {
		setMedicalrecords();
		personsByAddress.addAll(persons.stream().filter(p -> p.getAddress().matches(address)).collect(Collectors.toList()));
		personsByAddress.forEach(p -> residents.add(new Resident(p.getFirstName(),p.getLastName(),p.getAge(),p.getPhone(),p.getMedicalRecord())));
		System.out.println(residents);
		// TODO Auto-generated method stub
		//firestationMap.entrySet().parallelStream().filter(en -> {if (en.getValue().getAddresses().contains(address)) {station=en.getKey();};});
		firestationMap.forEach((k,v)  -> {if(v.getAddresses().contains(address)) {station=k;}});
		result=new FireResult(station,residents);
		return result;
	}

}
