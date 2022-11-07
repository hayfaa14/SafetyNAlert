package com.OC.SafetyNAlert.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MedicalrecordTest {
	
	private Medicalrecord medRecord;
	@Test
	public void toStringTest() {
		medRecord = new Medicalrecord("","","","","");
		String expextedResult= "{\"medicalrecords\": [\n{ \"firstName\":\""+""+"\","
				+ " \"lastName\":\""+""+"\","
						+ " \"birthdate\":\""+""+"\", "
								+ "\"medication\":\""+""+"\","
										+ "\"allergies\":\""+""+"\"}\n]}";
		
		String testResult=medRecord.toString();
		assertEquals(expextedResult,testResult);
	}

}
