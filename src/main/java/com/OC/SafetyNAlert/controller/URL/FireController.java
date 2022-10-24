package com.OC.SafetyNAlert.controller.URL;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.OC.SafetyNAlert.service.URL.IFireService;

import DTO.FireResult;

@RestController
public class FireController {
	
	@Autowired
	 private IFireService service;
	
	@GetMapping("fire")
	public FireResult getResidentsByAddress(@RequestParam String address){
		
		return service.getResidentsByAddress(address);
	}

}
