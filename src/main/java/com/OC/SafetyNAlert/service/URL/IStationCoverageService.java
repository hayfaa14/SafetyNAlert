package com.OC.SafetyNAlert.service.URL;

import java.util.List;

import DTO.PersonCovered;
import DTO.PersonsCoveredResult;

public interface IStationCoverageService {
	
	Long getNAdults();
	Long getNChildren();
	void setMedicalrecords();
	PersonsCoveredResult getStationCoverage(String station);


}
