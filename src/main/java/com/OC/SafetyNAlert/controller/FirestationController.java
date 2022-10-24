package com.OC.SafetyNAlert.controller;

import java.io.IOException;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.OC.SafetyNAlert.Shared.Result;
import com.OC.SafetyNAlert.model.Firestation;
import com.OC.SafetyNAlert.service.IFirestationService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class FirestationController {

	@Autowired
	IFirestationService firestationService;
	
	@ResponseBody
	@GetMapping("/firestations")
	public Map<String,Firestation> getFirestations() throws IOException,JsonProcessingException{
		return firestationService.getFirestations();
	}
	
	@PostMapping("/firestation")
	public Firestation saveFirestation(@RequestBody Firestation firestation) {
		return firestationService.saveFirestation(firestation);
		
	}
	
	@Transactional
	@DeleteMapping("firestation/delete/{address}")
	public Result deleteFirestationByAddress(@PathVariable String address) {
		return firestationService.deleteFirestationByAddress(address);
	}
	
	@PutMapping("/firestation/{station}")
	public Result updtateFirestation(@PathVariable String station, @RequestBody Firestation firestation ) {
		return firestationService.updateFiresationOfAnAddress(firestation, station);
	}
	
	@Transactional
	@DeleteMapping("firestation/delete/{station}")
	public Result deleteFirestationStation(@PathVariable("station")String station){
		return firestationService.deleteFirestationByStation(station);
	}
	

	
	
}
