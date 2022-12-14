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
import lombok.Generated;



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
		
		public int  calculateAge(){
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate birthDate = LocalDate.parse(this.medicalRecord.getBirthdate(), dateFormat);
			LocalDate today  = LocalDate.now();
			Period agePeriod =  Period.between(birthDate, today);
			this.age=agePeriod.getYears();
			return this.age;
		}
		
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
		public String getLastName() {
			return this.lastName;
		}
		@Generated
		public void setAddress(String address) {
			this.address=address;
		}
		@Generated
		public String getAddress() {
			return this.address;
		}
		@Generated
		public void setPhone(String phone) {
			this.phone=phone;
		}
		@Generated
		public String getPhone() {
			return this.phone;
		}
		@Generated
		public void setCity(String city) {
			this.city=city;
		}
		@Generated
		public String getCity() {
			return this.city;
		}
		@Generated
		public void setZip(String zip) {
			this.zip=zip;
		}
		@Generated
		public String getZip() {
			return this.zip;
		}
		@Generated
		public String getEmail() {
			return this.email;
		}
		
		@Generated
		public void setEmail(String email) {
			this.email=email;
		}
		
		public int getAge() {
			return this.age;
		}
		
		public void setAge(int age) {
			this.age=age;
		}
	@Override
	public String toString() {
		return "{\"persons\": [\n        { \"firstName\":\""+firstName+"\", \"lastName\":\""+lastName+"\", \"address\":\""+address+"\", \"city\":\""+city+"\", \"zip\":\""+zip+"\", \"phone\":\""+phone+"\", \"email\":\""+email+"\" }\n]}";
	}

	

}

