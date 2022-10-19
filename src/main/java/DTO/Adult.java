package DTO;

public class Adult {
	private String firstName;
	private String lastName;
	private int age;
	

	public Adult(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;

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
	
	@Override
	public String toString() {
		return "{\"Family members\": [\n        { \"firstName\":\""+firstName+"\", \"lastName\":\""+lastName+"}\n]}";
	}


	

}
