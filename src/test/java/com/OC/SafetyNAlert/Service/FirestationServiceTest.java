package com.OC.SafetyNAlert.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.OC.SafetyNAlert.Shared.Result;
import com.OC.SafetyNAlert.model.Firestation;
import com.OC.SafetyNAlert.repository.JsonFileRepo;
import com.OC.SafetyNAlert.service.FirestationService;
import com.OC.SafetyNAlert.service.IFirestationService;

@ExtendWith(MockitoExtension.class)
public class FirestationServiceTest {
	
	private IFirestationService firestationService;
	@Mock
	JsonFileRepo jsonReader;

	private Map<String,Firestation> firestationMap=new HashMap<>();
	
	@BeforeEach
	void setUp() throws IOException {
	Firestation firestation = new Firestation("1");
	firestation.addAddress("5 rue du Boulevard");
	firestationMap.put("1", firestation);
	when(jsonReader.readFirestation()).thenReturn(firestationMap);
	firestationService=new FirestationService(jsonReader);
	}
	
	
	@Test
	public void testGetFirestation() {
		assertEquals(firestationMap,firestationService.getFirestations());
	}
	
	
	@Test
	public void testSaveFirestation() {
		Firestation newFirestation=new Firestation("2");
		newFirestation.addAddress("79 avenue de la Gloire");
		firestationMap.put(newFirestation.getStation(), newFirestation);
		assertEquals(newFirestation,firestationService.saveFirestation(newFirestation));
		
	}
	
	@Test
	public void testDeleteFirestationByAddress() {
		Result testResult=firestationService.deleteFirestationByAddress("79 avenue de la Gloire");
		assertEquals(Result.success,testResult);
		
	}
	
	@Test
	public void testDeleteFirestationByStation() {
		Result testResult=firestationService.deleteFirestationByStation("2");
		assertEquals(Result.success,testResult);
	}
	
	@Test
	public void testUpdateFirestationOfAnAddress() {
		Firestation firestationUpdate= new Firestation("3");
		firestationUpdate.setAddress("79 avenue de la Gloire");
		String stationToUpdate = "2";
		Result testResult=firestationService.updateFiresationOfAnAddress(firestationUpdate, stationToUpdate);
		assertEquals(Result.success,testResult);
	}	
}
