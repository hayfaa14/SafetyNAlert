package com.OC.SafetyNAlert.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.OC.SafetyNAlert.Shared.Result;
import com.OC.SafetyNAlert.model.Firestation;
import com.OC.SafetyNAlert.repository.JsonFileRepo;

@Service
public class FirestationService implements IFirestationService {

	@Autowired
	JsonFileRepo reader;
	
	private Map<String,Firestation> addressesMap= new HashMap<>();
	
	
	public FirestationService(JsonFileRepo reader) throws IOException{
		this.addressesMap=reader.readFirestation();
	}
	
	public Map<String,Firestation> getFirestations(){
		return addressesMap;
	}

	public Firestation saveFirestation(Firestation firestation) {
		addressesMap.put(firestation.getStation(), firestation.addAddress(firestation.getAddress()));
		return firestation;
	}
	
	public Result deleteFirestationByAddress(String address) {
		addressesMap.values().stream().filter(toRemove -> !toRemove.getAddresses().contains(address));
		if(addressesMap.values().contains(address)) {
			return Result.failure;
		} 
		return Result.success;
	}
	
	public Result deleteFirestationByStation(String station) {
		addressesMap.remove(station);
		if(addressesMap.entrySet().contains(station)) {
			return Result.failure;
		}
		return Result.success;
	}
	
	public Result updateFiresationOfAnAddress(Firestation firestation, String station, String address) {
		for(Firestation firestations:addressesMap.values()) {
			if(firestations.getStation().equals(station)) {
				addressesMap.remove(station, address);
				addressesMap.put(firestation.getStation(), firestation);
				return Result.success;
			}
		}
		
		return Result.failure;
		
	}

	
		
}
