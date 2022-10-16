package com.OC.SafetyNAlert.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
@Entity
@Table(name="medicalrecords")
public class Medicalrecord {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String firstName;
	private String lastName;
	private String birthdate;
	private String medications; 
	private String allergies;
	
	public Medicalrecord() {
		
	}
	
public Medicalrecord(String firstName, String lastName, String birthdate, String medications, String allergies) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.birthdate=birthdate;
		this.medications=medications;
		this.allergies=allergies;
	}
	
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setLastName(String lastName) {
		this.lastName=lastName;
	}

	public String getLastname() {
		return this.lastName;
	}

	public String getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	

	public String getMedications() {
		return this.medications;
	}


	public void setMedications(String medications) {
		this.medications = medications;
	}


	public String getAllergies() {
		return this.allergies;
	}


	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	
	@Override
	public String toString() {
		return "{\"medicalrecords\": [\n{ \"firstName\":\""+firstName+"\", \"lastName\":\""+lastName+"\", \"birthdate\":\""+birthdate+"\", \"medication\":\""+medications+"\",\"allergies\":\""+allergies+"\"}\n]}";
	}
	

}
