package com.OC.SafetyNAlert.controller.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.OC.SafetyNAlert.service.URL.IStationCoverageService;

import DTO.PersonsCoveredResult;

/**
 * This endpoint gives information about the persons covered by a station which
 * is our parameter The persons covered are listed with detail about : their
 * name, address and phone number. The number of adult covered is also mentioned
 */

@RestController
public class StationCoverageController {
	@Autowired
	private IStationCoverageService service;

	@GetMapping("firestation")
	public PersonsCoveredResult getStationCoverage(@RequestParam String station) {
		return service.getStationCoverage(station);
	}

}
