package com.OC.SafetyNAlert.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OC.SafetyNAlert.Shared.Result;
import com.OC.SafetyNAlert.model.Medicalrecord;
import com.OC.SafetyNAlert.repository.JsonFileRepo;

@Service
public class MedicalrecordService implements IMedicalrecordService {
	
	@Autowired
	private JsonFileRepo jsonReader;
	
	private List<Medicalrecord> medicalRecords;
	
	public MedicalrecordService(JsonFileRepo jsonReader) {
		this.medicalRecords=jsonReader.readMedicalrecord();
	}
	
	public List<Medicalrecord> getMedicalRecords(){
		return this.medicalRecords;
	}
	
	public Medicalrecord addMedicalRecord(Medicalrecord medicalRecord) {
		medicalRecords.add(new Medicalrecord(medicalRecord.getFirstName(),medicalRecord.getLastname(),medicalRecord.getBirthdate(),
				medicalRecord.getMedications(),medicalRecord.getAllergies()));
		return medicalRecord;
	}
	
	
	public Result deleteMedicalRecord(String firstName, String lastName) {
		for(Medicalrecord medRecord:medicalRecords) {
			if(medRecord.getFirstName().equals(firstName) && medRecord.getLastname().equals(lastName)) {
				medicalRecords.remove(medRecord);
				return Result.success;
			}
		}
		return Result.failure;
	}
	
	public Result updateMedicalRecord(Medicalrecord medicalRecord, String firstName, String lastName) {
		for(Medicalrecord medRecord:medicalRecords) {
			if(medRecord.getFirstName().equals(medicalRecord.getFirstName()) && medRecord.getLastname().equals(medicalRecord.getLastname())){
				int indexToUpdate=medicalRecords.indexOf(medRecord);
				medicalRecords.set(indexToUpdate, medicalRecord);
				return Result.success;
			}
		}
		
		
		return Result.failure;
	}
	}


