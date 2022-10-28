package com.OC.SafetyNAlert.service.URL;



import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.OC.SafetyNAlert.model.Medicalrecord;
import com.OC.SafetyNAlert.model.Person;
import com.OC.SafetyNAlert.repository.JsonFileRepo;

import DTO.Adult;
import DTO.Child;

@Service
public class ChildAlertService implements IChildAlertService{
	
	

	
	private List<Person> persons;
	private List<Person> children = new ArrayList<>();
	private List<Person> adults = new ArrayList<>();
	private List<Medicalrecord> medRecords = new ArrayList<>();
	private List<Child> childrenByAddress= new ArrayList<>();
	private List<Adult> familyMembersByAddress=new ArrayList<>();
	private SharedMethods sm = new SharedMethods();
	
	public  ChildAlertService(JsonFileRepo reader) {
		this.persons=reader.readPerson();
		this.medRecords=reader.readMedicalrecord();
	}

	/*
	private void setMedicalrecords() {
		for(int i=0;i<persons.size();i++) {
			persons.get(i).setMedicalRecord(medRecords.get(i));
			System.out.println("inside set medical records ");
		}
	}
	*/

	public List<Child> getChildAlert(String address) throws ParseException {
		sm.setMedicalrecords(persons,medRecords);
		sm.calculateAge(persons);
		
		children=persons.stream().filter(p -> p.getAddress().equals(address)).collect(Collectors.toList());
		children=children.stream().filter(p -> p.isAChild()).collect(Collectors.toList());
		
		adults=persons.stream().filter(p -> p.getAddress().equals(address)).collect(Collectors.toList());
		adults=adults.stream().filter(p -> !p.isAChild()).collect(Collectors.toList());
		
		adults.forEach(a -> familyMembersByAddress.add(new Adult(a.getFirstName(),a.getLastName())));
		children.forEach(c -> childrenByAddress.add(new Child(c.getFirstName(),c.getLastName(),c.getAge(),
				familyMembersByAddress)));
		//System.out.println(childrenByAddress);
		return this.childrenByAddress;
		
		}		
	}
	
	


