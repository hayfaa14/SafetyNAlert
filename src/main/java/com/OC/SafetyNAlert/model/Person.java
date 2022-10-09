package com.OC.SafetyNAlert.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
		
		public Person() {
			
		}
		
		public Person(String firstName, String lastName, String address, String phone, String city, String zip, String email) {
			this.firstName=firstName;
			this.lastName= lastName;
			this.address= address;
			this.phone= phone;
			this.city= city;
			this.zip= zip;
			this.email= email;
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
		
		

		

		

	@Override
	public String toString() {
		return "{\"persons\": [\n        { \"firstName\":\""+firstName+"\", \"lastName\":\""+lastName+"\", \"address\":\""+address+"\", \"city\":\""+city+"\", \"zip\":\""+zip+"\", \"phone\":\""+phone+"\", \"email\":\""+email+"\" }\n]}";
	}

	

}

