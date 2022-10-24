package com.OC.SafetyNAlert.controller;

import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.OC.SafetyNAlert.Shared.Result;
import com.OC.SafetyNAlert.model.Medicalrecord;
import com.OC.SafetyNAlert.service.IMedicalrecordService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class MedicalrecordController {
	
	@Autowired
	private IMedicalrecordService medicalService;
	
	
	@GetMapping("/medicalrecords")
	public Iterable<Medicalrecord> getMedicalRecords() throws IOException,JsonProcessingException{
		return medicalService.getMedicalRecords();
	}
	
	
	@PostMapping("/medicalrecord")
	public Medicalrecord createMedicalRecord(@RequestBody Medicalrecord medicalRecord) {
		return medicalService.addMedicalRecord(medicalRecord);
	}
	@PutMapping("/medicalrecord/{firstName}/{lastName}")
    public Medicalrecord updatePerson(@RequestBody Medicalrecord medicalRecord,@PathVariable String firstName,@PathVariable String lastName) {
		medicalService.updateMedicalRecord(medicalRecord, firstName, lastName);
        return medicalRecord;
    }
	
	@Transactional
	@DeleteMapping("medicalrecord/delete/{firstName}/{lastName}")
	public Result deleteFirestationStation(@PathVariable String firstName,@PathVariable String lastName){
		return medicalService.deleteMedicalRecord(firstName, lastName);
	}

}
