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
	Firestation firestation2 = new Firestation("3");
	firestation.addAddress("51 cours tolstoi");
	firestationMap.put("1", firestation);
	firestationMap.put("3", firestation2);
	when(jsonReader.readFirestation()).thenReturn(firestationMap);
	firestationService=new FirestationService(jsonReader);
	}
	
	
	@Test
	public void testGetFirestation() {
		assertEquals(firestationMap,firestationService.getFirestations());
	}
	
	
	@Test
	public void testSaveFirestation() {
		Firestation newFirestation=new Firestation("3");
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
		Result testResult=firestationService.deleteFirestationByStation("1");
		assertEquals(Result.success,testResult);
	}
	
	
	
	@Test
	public void testUpdateFirestationOfAnAddress() {
		Firestation firestationUpdate= new Firestation("3");
		firestationUpdate.setStation("3");
		firestationUpdate.setAddress("51 cours tolstoi");
		
		Result testResult=firestationService.updateFiresationOfAnAddress(firestationUpdate, "3","52 cours tolstoi");
		assertEquals(Result.success,testResult);
	}	
	
}
