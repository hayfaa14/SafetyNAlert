package com.OC.SafetyNAlert.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table

public class JsonFile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@OneToMany(cascade=CascadeType.ALL,targetEntity=Person.class)
	@JoinColumn(name="persons")
	List<Person> persons;
	

	@OneToMany(cascade=CascadeType.ALL,targetEntity=Firestation.class)
	@JoinColumn(name="firestations")
	List<Firestation> firestations;
	

	@OneToMany(cascade=CascadeType.ALL,targetEntity=Medicalrecord.class)
	@JoinColumn(name="medicalrecords")
	List<Medicalrecord> medicalrecords;
	
	public List<Person> getPersons(){
		return this.persons;
	}
	
	public void setPersons(List<Person> persons){
		this.persons=persons;
		
	}
	
	public List<Firestation> getFirestations(){
		return firestations;
	}

	public List<Medicalrecord> getMedicalrecords(){
		return this.medicalrecords;
	}
	
	public void setMedicalrecords(List<Medicalrecord> medicalRecords){
		this.medicalrecords=medicalRecords;
	}
	
	@Override
	public String toString() {
		return "{\"persons\": [\n        { \"persons\":\""+persons+"\", \"firestations\":\""+firestations+"\", \"medicalrecords\":\""+medicalrecords+"\"}\n]}";
	}

	


}
