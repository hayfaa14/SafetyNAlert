package com.OC.SafetyNAlert.service.URL;

import java.util.List;

import org.springframework.stereotype.Component;

import com.OC.SafetyNAlert.model.Medicalrecord;
import com.OC.SafetyNAlert.model.Person;

@Component
public class SharedMethods {
	
	public void calculateAge(List<Person> persons) {
		for(Person p:persons) {
			p.calculateAge();
		}
	}

	public void setMedicalrecords(List<Person> persons, List<Medicalrecord> medRecords) {
		for(int i=0;i<persons.size();i++) {
			persons.get(i).setMedicalRecord(medRecords.get(i));
		}
		
	}
	
	

}
