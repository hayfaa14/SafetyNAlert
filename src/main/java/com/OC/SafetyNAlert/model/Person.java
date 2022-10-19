package com.OC.SafetyNAlert.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;



@Data
@Entity
@Table
public class Person {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		
		private String firstName;
		private String lastName;
		private String address;
		private String phone;
		private String city;
		private String zip;
		private String email;
		
		@JsonIgnore
		private int age;
		
		@Transient
		private Medicalrecord medicalRecord;
		
		@Transient
		@JsonIgnore
		public Boolean isAChild() {
			
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate birthDate = LocalDate.parse(this.medicalRecord.getBirthdate(), dateFormat);
			LocalDate today  = LocalDate.now();
			Period age =  Period.between(birthDate, today);
			
			if (age.getYears()>18) {
				this.age=age.getYears();
				return false;
			}
			this.age=age.getYears();
			return true;
		}
		
		
		public Person() {
			
		}
		
		public Person(String firstName, String lastName, String address, String city, String zip,String phone, String email) {
			this.firstName=firstName;
			this.lastName= lastName;
			this.address= address;
			this.phone= phone;
			this.city= city;
			this.zip= zip;
			this.email= email;
		}
		public void setMedicalRecord(Medicalrecord record) {
			this.medicalRecord=record;
		}
		
		@JsonIgnore
		public Medicalrecord getMedicalRecord() {
			return this.medicalRecord;
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
		
		public String getLastName() {
			return this.lastName;
		}
		
		public void setAddress(String address) {
			this.address=address;
		}
		
		public String getAddress() {
			return this.address;
		}
		
		public void setPhone(String phone) {
			this.phone=phone;
		}
		
		public String getPhone() {
			return this.phone;
		}
		
		public void setCity(String city) {
			this.city=city;
		}
		
		public String getCity() {
			return this.city;
		}
		
		public void setZip(String zip) {
			this.zip=zip;
		}
		
		public String getZip() {
			return this.zip;
		}
		
		public String getEmail() {
			return this.email;
		}
		
		public void setEmail(String email) {
			this.email=email;
		}
		
		public int getAge() {
			return this.age;
		}
	@Override
	public String toString() {
		return "{\"persons\": [\n        { \"firstName\":\""+firstName+"\", \"lastName\":\""+lastName+"\", \"address\":\""+address+"\", \"city\":\""+city+"\", \"zip\":\""+zip+"\", \"phone\":\""+phone+"\", \"email\":\""+email+"\" }\n]}";
	}

	

}

