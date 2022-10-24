package com.OC.SafetyNAlert.service.URL;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.OC.SafetyNAlert.model.Medicalrecord;
import com.OC.SafetyNAlert.model.Person;
import com.OC.SafetyNAlert.repository.JsonFileRepo;

import DTO.PersonInfo;

@Service
public class PersonInfoService implements IPersonInfoService{
	
	private List<Person> persons= new ArrayList<>();
	private List<Medicalrecord> medRecords= new ArrayList<>();
	private List<PersonInfo> personsInfo = new ArrayList<>();
	private List<Person> personsMatch = new ArrayList<>();
	
	public PersonInfoService(JsonFileRepo jsonReader) {
		this.persons=jsonReader.readPerson();
		this.medRecords=jsonReader.readMedicalrecord();

	}
	
	private void setMedicalRecords() {
		for(int i=0;i<persons.size();i++) {
			persons.get(i).setMedicalRecord(medRecords.get(i));
		}
	}

	@Override
	public List<PersonInfo> getPersonInfo(String firstName, String lastName) {
		// TODO Auto-generated method stub
		setMedicalRecords();
		//System.out.println(persons);
		personsMatch.addAll(persons.stream().filter(p ->  p.getFirstName().equals(firstName)).filter(p -> p.getLastName().equals(lastName)).collect(Collectors.toList()));
		personsMatch.forEach(p -> personsInfo.add(new PersonInfo(p.getFirstName(),p.getLastName(),p.getAddress(),p.getAge(),p.getEmail(),p.getMedicalRecord())));
		
		return personsInfo;
	}

}
