package com.OC.SafetyNAlert.service;

import java.util.List;

import com.OC.SafetyNAlert.Shared.Result;
import com.OC.SafetyNAlert.model.Medicalrecord;

public interface IMedicalrecordService {
	
	List<Medicalrecord> getMedicalRecords();
	Medicalrecord addMedicalRecord(Medicalrecord medicalRecord);
	Result deleteMedicalRecord(String firstName, String lastName);
	Result updateMedicalRecord(Medicalrecord medicalRecord, String firstName, String lastName);

}
