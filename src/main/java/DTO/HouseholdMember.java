package DTO;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import com.OC.SafetyNAlert.model.Medicalrecord;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class HouseholdMember {
	
	private String firstName;
	private String lastName;
	private String phone;
	private int age;

	private String allergies;
	private String medication;
	
	@JsonIgnore
	private Medicalrecord medRecords;
	
	@JsonIgnore
	private String address;
	
	
	public HouseholdMember(String firstName, String lastName, String phone, int age, Medicalrecord medRecords,String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.age = age;
		this.medRecords = medRecords;
		this.address=address;
	}


	public String getAllergies() {
		return medRecords.getAllergies();
	}


	public void setAllergies(String allergies) {
		this.medRecords.setAllergies(allergies);
	}


	public String getMedication() {
		return medRecords.getMedications();
	}


	public void setMedication(String medication) {
		this.medRecords.setMedications(medication);
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
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


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public int getAge() {
		return age;
	}
	
	private int calculateAge() {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate birthDate = LocalDate.parse(this.medRecords.getBirthdate(), dateFormat);
		LocalDate today  = LocalDate.now();
		Period agePeriod =  Period.between(birthDate, today);
		age=agePeriod.getYears();
		return age;
	}



	public void setAge(int age) {
		this.age = calculateAge();
	}


	public Medicalrecord getMedRecords() {
		return medRecords;
	}


	public void setMedRecords(Medicalrecord medRecords) {
		this.medRecords = medRecords;
	}
	
	@Override
	public String toString() {
		return "{\"HousedMembers\": [\n        { \"firstName\":\""+firstName+"\", \"lastName\":\""+lastName+"\", \"phone\":\""+phone+"\", \"age\":\""+age+"\", \"allergies\":\""+allergies+"\", \"medication\":\""+medication+"\" }\n]}";
	}
	
	

}
