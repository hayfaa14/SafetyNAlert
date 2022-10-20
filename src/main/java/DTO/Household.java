package DTO;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Household {
	
	private Set<HouseholdMember> addresses=new HashSet<>();
	private HouseholdMember householdMember;
	private String address;
	
	
	public Household(String address) {
		this.address=address;
	}
	
	public Set<HouseholdMember> getAddresses(){
		return addresses.stream().collect(Collectors.toSet());
	}
	public Household addHouseholdMember(HouseholdMember member) {
		addresses.add(member);
		return this;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "{\"Households\": [\n{ \"address\":\""+address+"\", \"Household members\":\""+householdMember+"\" }\n]}";
	}

}
