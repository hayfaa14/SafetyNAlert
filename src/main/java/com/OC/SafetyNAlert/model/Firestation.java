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
public class Firestation {
	
	
	public Firestation() {}
	


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String address;
	
	private String station;
	
	public String getAddress() {
		return address;
	}

	public void setAddres(String address) {
		this.address = address;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}
	
	@Override
	public String toString() {
		return "{\"firestations\": [\n{ \"address\":\""+address+"\", \"station\":\""+station+"\" }\n]}";
	}

}
