package com.OC.SafetyNAlert.Controller.URL;

import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.OC.SafetyNAlert.controller.URL.CommunityEmailController;
import com.OC.SafetyNAlert.service.URL.CommunityEmailService;

@WebMvcTest(controllers = CommunityEmailController.class)
public class CommunityEmailTest {

	@Autowired
	private MockMvc mockMvc;

	String city = "Culver";

	@MockBean
	private CommunityEmailService service;

	@Test
	public void testGetCommunityEmail() throws Exception {
		mockMvc.perform(get("/communityEmail").param("city", city)).andExpect(status().isOk());
	}

}
