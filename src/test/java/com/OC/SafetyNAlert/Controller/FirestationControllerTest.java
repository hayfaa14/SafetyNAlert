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
import com.OC.SafetyNAlert.controller.FirestationController;
import com.OC.SafetyNAlert.service.FirestationService;

@WebMvcTest(controllers = FirestationController.class)
public class FirestationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FirestationService service;

	@Test
	void getFirestations() throws Exception {
		mockMvc.perform(get("/firestations")).andExpect(status().isOk());

	}
	

	
	@Test
	public void addFirestation() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/firestation").accept(MediaType.APPLICATION_JSON).content(

				"{\"station\":1,\"addresss\":\"birthdate\"}"

		).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
		
	}
	
	

	
	
	
	

}
