package com.OC.SafetyNAlert.controller.URL;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.OC.SafetyNAlert.service.URL.IFloodService;

import DTO.Household;
import DTO.HouseholdMember;
/**
 * This endpont wants to return the households covered by a certai nstation. 
 * Household details contain: the address and details about the different members. 
 */
@RestController
public class FloodController {
	
	@Autowired
	IFloodService service;

	@GetMapping("flood")
	public HashMap<String,List<HouseholdMember>> getHouseholds(@RequestParam String station){
		return service.getHouseholds(station);
	}
}
