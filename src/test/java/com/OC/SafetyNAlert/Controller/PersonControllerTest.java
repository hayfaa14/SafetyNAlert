package com.OC.SafetyNAlert.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.OC.SafetyNAlert.controller.PersonController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PersonController.class)
public class PersonControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PersonController service;
	
	private String firstName = "Sophia";
	private String lastName = "Zemicks";

	@Test
	void getPersonsTestStatus() throws Exception {
		mockMvc.perform(get("/persons")).andExpect(status().isOk());

	}

	@Test
	public void addPersonTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/person").accept(MediaType.APPLICATION_JSON).content(

				"{\"firstName\":1,\"lastName\":\"address\",\"phone\":10,\"city\":100,\"zip\":10,\"city\":100}"

		).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
	}
	


}
