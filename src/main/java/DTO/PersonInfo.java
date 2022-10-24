package DTO;

import com.OC.SafetyNAlert.model.Medicalrecord;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class PersonInfo {
	
	
	
	private String firstName;
	private String lastName;
	private String address;
	private int age;
	private String email;
	private String medication;
	private String allergies;
	@JsonIgnore
	private Medicalrecord medRecord;

	public PersonInfo(String firstName, String lastName, String address, int age, String email, Medicalrecord medRecord) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.address=address;
		this.age=age;
		this.email=email;
		this.medRecord=medRecord;

	}
	
	public Medicalrecord getMedRecords() {
		return medRecord;
	}


	public void setMedRecords(Medicalrecord medRecords) {
		this.medRecord = medRecords;
	}
	
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMedication() {
		return this.medRecord.getMedications();
	}

	public void setMedication(String medication) {
		this.medication = this.medRecord.getMedications();
	}

	public String getAllergies() {
		return this.medRecord.getAllergies();
	}

	public void setAllergies(String allergies) {
		this.allergies = this.medRecord.getAllergies();
	}
	
	@Override
	public String toString() {
		return "{\"persons Info\": [\n        { \"firstName\":\""+firstName+"\", \"lastName\":\""+lastName+"\", \"address\":\""+address+"\", \"age\":\""+age+"\", \"email\":\""+email+"\", \"medication\":\""+medication+"\", \"allergies\":\""+allergies+"\" }\n]}";
	}

}
