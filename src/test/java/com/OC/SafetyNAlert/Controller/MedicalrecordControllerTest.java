package com.OC.SafetyNAlert.Controller;

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
import com.OC.SafetyNAlert.service.MedicalrecordService;

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
	public void addMedicalRecord() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/medicalrecord").accept(MediaType.APPLICATION_JSON).content(

				"{\"firstName\":1,\"lastName\":\"birthdate\",\"medications\":10,\"allergies\":100}"

		).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
	}



}
