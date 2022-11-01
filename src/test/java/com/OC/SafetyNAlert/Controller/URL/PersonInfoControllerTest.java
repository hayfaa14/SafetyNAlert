package com.OC.SafetyNAlert.Controller.URL;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.OC.SafetyNAlert.controller.URL.PersonInfoController;
import com.OC.SafetyNAlert.service.URL.PersonInfoService;

@WebMvcTest(controllers = PersonInfoController.class)
public class PersonInfoControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PersonInfoService service;

	private String firstName = "Sophia";
	private String lastName = "Zemmicks";

	@Test
	public void testGetResidentsBByAddress() throws Exception {
		mockMvc.perform(get("/personInfo").param("firstName", firstName).param("lastName", lastName)).andExpect(status().isOk());

	}
}
