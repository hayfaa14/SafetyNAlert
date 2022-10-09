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
	
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
    @JsonProperty("birthdate")
    @JsonFormat(pattern="dd/MM/yyyy")
	private Date birthdate;
	
    @ElementCollection
    @CollectionTable(name="medications")
    @Column(name="medications")
	private List<String> medications;
	
    @ElementCollection
    @CollectionTable(name="allergies")
    @Column(name="allergies")
	private List <String> allergies;
	
	public Medicalrecord() {
		
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

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	

	public List<String> getMedications() {
		return this.medications;
	}


	public void setMedications(List<String> medications) {
		this.medications = medications;
	}


	public List<String> getAllergies() {
		return this.allergies;
	}


	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}
	
	@Override
	public String toString() {
		return "{\"persons\": [\n{ \"firstName\":\""+firstName+"\", \"lastName\":\""+lastName+"\", \"birthdate\":\""+birthdate+"\", \"medication\":\""+medications+"\",\"allergies\":\""+allergies+"\"}\n]}";
	}
	

}
