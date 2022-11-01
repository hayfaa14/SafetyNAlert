package DTO;

import java.util.HashMap;
import java.util.List;

public class PersonsCoveredResult {
	

	private List<PersonCovered> personsCovered;
	private HashMap<String,Long> nAdultsChildren;
	
	
	
	 public PersonsCoveredResult(List<PersonCovered> personsCovered, HashMap<String,Long> nAdultsChildren ) {
		this.personsCovered=personsCovered;
		this.nAdultsChildren=nAdultsChildren;
	}
	 
	public List<PersonCovered> getPersonsCovered() {
		return this.personsCovered;
	}
	
	public void setChildren() {
		
	}
	
	public HashMap<String,Long> getnAdultsChildren(){
		return this.nAdultsChildren;
	}
	
	
	@Override
	public String toString() {
		return "{\"Station Coverage\": [\n { \"Persons Covered\":\""+personsCovered+"\", \"Number of children and adults\":\""+nAdultsChildren+"\"}\n]}";
	}
	

}
