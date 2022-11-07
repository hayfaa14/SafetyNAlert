package com.OC.SafetyNAlert.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.Generated;
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
	@Generated
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	@Generated
	public String getFirstName() {
		return this.firstName;
	}
	@Generated
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
	@Generated
	public String getLastname() {
		return this.lastName;
	}
	@Generated
	public String getBirthdate() {
		return this.birthdate;
	}
	@Generated
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	
	@Generated
	public String getMedications() {
		return this.medications;
	}

	@Generated
	public void setMedications(String medications) {
		this.medications = medications;
	}

	@Generated
	public String getAllergies() {
		return this.allergies;
	}

	@Generated
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	
	@Override
	public String toString() {
		return "{\"medicalrecords\": [\n{ \"firstName\":\""+firstName+"\", \"lastName\":\""+lastName+"\", \"birthdate\":\""+birthdate+"\", \"medication\":\""+medications+"\",\"allergies\":\""+allergies+"\"}\n]}";
	}
	

}
