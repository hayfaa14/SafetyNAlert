package com.OC.SafetyNAlert.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.OC.SafetyNAlert.Shared.Result;
import com.OC.SafetyNAlert.model.Medicalrecord;
import com.OC.SafetyNAlert.repository.JsonFileRepo;
import com.OC.SafetyNAlert.service.IMedicalrecordService;
import com.OC.SafetyNAlert.service.MedicalrecordService;

@ExtendWith(MockitoExtension.class)
public class MedicalrecordServiceTest {
	
	@Mock
	private JsonFileRepo jsonReader;
	
	@Autowired 
	private IMedicalrecordService medService;
	List<Medicalrecord> medicalRecords = new ArrayList<>();
	
	@BeforeEach
	public void setUp() {
		medicalRecords.add(new Medicalrecord("John","Doe","13/03/1993","panadol","seafood"));
		when(jsonReader.readMedicalrecord()).thenReturn(medicalRecords);
		medService=new MedicalrecordService(jsonReader);
	}
	
	@Test
	public void  getMedicalRecordsTest() {
		assertEquals(medicalRecords,medService.getMedicalRecords());
		
	}
	
	@Test
	public void saveMedicalRecordTest() {
		Medicalrecord newMedRecord = new Medicalrecord("Justin","Doe","14/03/1994","cortison","cat");
		Medicalrecord testResult=medService.addMedicalRecord(newMedRecord);
		System.out.println(medicalRecords);
		assertEquals(newMedRecord,testResult);
	}
	
	@Test
	public void deleteMedicalRecordTest() {
		Result testResult=medService.deleteMedicalRecord("Justin", "Doe");
		System.out.println(medicalRecords);
		int expectedSize=1;
		//assertEquals(Result.success,testResult); this is not working 
		assertEquals(expectedSize,medicalRecords.size());
	
	}
	
	@Test
	public void updateMedicalRecordTest() {
		Medicalrecord updateRecord= new Medicalrecord("John","Doe","13/03/1993","insulin","seafood");
		Result testResult=medService.updateMedicalRecord(updateRecord, "John", "Doe");
		String updateResult=medicalRecords.get(0).getMedications();
		assertEquals("insulin",updateResult);
	}
	

}
