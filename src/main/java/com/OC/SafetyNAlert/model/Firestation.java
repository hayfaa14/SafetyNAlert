package com.OC.SafetyNAlert.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Data;
import lombok.Generated;



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
	@Transient
	private Set<String> addresses=new HashSet<>();
	
	public Firestation(String station) {
		this.station=station;
	}
	
	public Firestation addAddress(String address) {
		addresses.add(address);
		return this;
	}
	
	public Set<String> getAddresses(){
		return addresses.stream().collect(Collectors.toSet());
	}
	@Generated
	public String getStation() {
		return this.station;
	}
	@Generated
	public void setStation(String station) {
		 this.station=station;
	}
	@Generated
	public void setAddress(String address) {
		 this.address=address;
	}

	@Generated
	public String getAddress() {
		return this.address;
	}

	@Override
	public String toString() {
		return "{\"firestations\": [\n{ \"address\":\""+address+"\", \"station\":\""+station+"\" }\n]}";
	}

}
