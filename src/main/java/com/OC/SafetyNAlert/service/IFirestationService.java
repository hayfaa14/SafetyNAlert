package com.OC.SafetyNAlert.service;


import java.util.Map;
import com.OC.SafetyNAlert.Shared.Result;
import com.OC.SafetyNAlert.model.Firestation;

public interface IFirestationService {
	
	 Map<String,Firestation> getFirestations();
	 Firestation saveFirestation(Firestation firestation);
	 Result deleteFirestationByAddress(String address);
	 Result deleteFirestationByStation(String station);
	 Result updateFiresationOfAnAddress(Firestation firestation, String station, String address);
}
