package DTO;

import lombok.Generated;

public class Adult {
	private String firstName;
	private String lastName;
	
	public Adult(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;

	}
	@Generated
	public String getFirstName() {
		return firstName;
	}
	@Generated
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Generated
	public String getLastName() {
		return lastName;
	}
	@Generated
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "{\"Family members\": [\n        { \"firstName\":\""+firstName+"\", \"lastName\":\""+lastName+"}\n]}";
	}


	

}
