package com.OC.SafetyNAlert.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.OC.SafetyNAlert.controller.MedicalrecordController;
import com.OC.SafetyNAlert.model.Medicalrecord;
import com.OC.SafetyNAlert.model.Person;
import com.OC.SafetyNAlert.service.MedicalrecordService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = MedicalrecordController.class)
public class MedicalrecordControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MedicalrecordService service;

	@Test
	void getMedicalRecord() throws Exception {
		mockMvc.perform(get("/medicalrecords")).andExpect(status().isOk());

	}
	

	
	@Test
	public void addMedRecordTest() throws Exception {
		Medicalrecord medRecord= new Medicalrecord();
		medRecord.setFirstName("Hayfaa");
		medRecord.setLastName("Aukloo");
		medRecord.setAllergies("peanut");
		medRecord.setMedications("panadol");
		medRecord.setBirthdate("14/03/1994");
		
	
		ObjectMapper objectMapper = new ObjectMapper();
		String inputJson=objectMapper.writeValueAsString(medRecord);
		MvcResult result=mockMvc.perform(MockMvcRequestBuilders.post("/medicalrecord").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(inputJson)).andReturn();
		   int status = result.getResponse().getStatus();
		   assertEquals(200, status);
			
	}
	
	
	@Test
	public void updateMedicalRecord() throws Exception{
		String uri="/medicalrecord/Hayfaa/Aukloo";
		Medicalrecord medRecord = new Medicalrecord();
		medRecord.setAllergies("pollen");
		ObjectMapper objectMapper = new ObjectMapper();
		String inputJson=objectMapper.writeValueAsString(medRecord);
		MvcResult result=mockMvc.perform(MockMvcRequestBuilders.put(uri).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(inputJson)).andReturn();
		   int status = result.getResponse().getStatus();
		   assertEquals(200, status);
		
	}
	
	
	   @Test
	   public void deleteMedicalRecord() throws Exception {
	      String uri = "/medicalrecord/delete/Hayfaa/Aukloo";
	      MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);

	   }



}
