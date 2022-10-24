package com.OC.SafetyNAlert.service.URL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.OC.SafetyNAlert.model.Firestation;
import com.OC.SafetyNAlert.model.Medicalrecord;
import com.OC.SafetyNAlert.model.Person;
import com.OC.SafetyNAlert.repository.JsonFileRepo;

import DTO.PersonCovered;
import DTO.PersonsCoveredResult;

@Service
public class StationCoverageService implements IStationCoverageService{
	
	private List<Person> persons;
	private Map<String,Firestation> firestationsMap;
	private List<PersonCovered> personsCovered= new ArrayList<>();
	private List<Person> personsCoveredByStation=new ArrayList<>();
	private List<String> firestations = new ArrayList<>();
	private List<Medicalrecord> medRecords=new ArrayList<>();
	
	
	PersonsCoveredResult result;
	
	private long nAdults=0;
	private long nChildren=0;

	
	public Long getNChildren() {
		return this.nChildren;
	}
	
	public Long getNAdults() {
		return this.nAdults;
	}
	
	private HashMap<String,Long> nAdultsChildren=new HashMap<>();
	
	public HashMap<String,Long> getAdultsChildren(){
		return this.nAdultsChildren;
	}
	
	public StationCoverageService(JsonFileRepo jsonReader) {
		this.firestationsMap=jsonReader.readFirestation();
		this.persons=jsonReader.readPerson();
		this.medRecords=jsonReader.readMedicalrecord();
	}
	
	public void setMedicalrecords() {
		for(int i=0;i<persons.size();i++) {
			persons.get(i).setMedicalRecord(medRecords.get(i));
		}
		
	}
	
	public PersonsCoveredResult getStationCoverage(String station) {
		setMedicalrecords();
		firestations.addAll(firestationsMap.get(station).getAddresses());
		firestations.forEach(
				ad -> personsCoveredByStation.addAll(persons.stream().filter(p ->
				p.getAddress().equals(ad)).collect(Collectors.toList())));
		

		personsCoveredByStation.forEach(
				pc -> {personsCovered.add(new PersonCovered(pc.getFirstName(),pc.getLastName(),pc.getAddress(),pc.getPhone()));
				
				if(pc.isAChild()) {
					this.nChildren++;
				}
				
				if(!pc.isAChild()) {
					this.nAdults++;
				}});
		
		this.nAdultsChildren.put("Adults", this.nAdults);
		this.nAdultsChildren.put("Children", this.nChildren);
		
		 result=new PersonsCoveredResult(personsCovered,nAdultsChildren);
		//System.out.println(result);
		return result ;
	}
	}


