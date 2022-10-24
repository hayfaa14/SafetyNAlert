package DTO;

import java.util.ArrayList;
import java.util.List;

import com.OC.SafetyNAlert.model.Person;

public class Child {
	private String firstName;
	private String lastName;
	private int age;
	private List<Adult> familyMembers= new ArrayList<>();
	
	
	public List<Adult> getFamilyMembers() {
		return familyMembers;
	}
	public void setFamilyMembers(String firstName, String lastName) {
		familyMembers.add(new Adult(firstName,lastName));
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Child(String firstName, String lastName, int age, List<Adult> family) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age=age;
		this.familyMembers=family;
	}
	
	@Override
	public String toString() {
		return "{\"children\": [\n { \"firstName\":\""+firstName+"\", \"lastName\":\""+lastName+"\", \"age\":\""+age+"\", \"family\":\""+familyMembers+"\"}\n]}";
	}
	

}
