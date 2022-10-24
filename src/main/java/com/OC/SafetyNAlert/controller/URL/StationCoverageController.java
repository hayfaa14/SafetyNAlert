package com.OC.SafetyNAlert.controller.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.OC.SafetyNAlert.service.URL.IStationCoverageService;

import DTO.PersonsCoveredResult;

@RestController
public class StationCoverageController {
	
	@Autowired
	private IStationCoverageService service;
	
	@GetMapping("firestation")
	public PersonsCoveredResult getStationCoverage(@RequestParam String station){
		return service.getStationCoverage(station);
	}

}
