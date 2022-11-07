package com.OC.SafetyNAlert.Controller.URL;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.OC.SafetyNAlert.controller.URL.PhoneAlertController;
import com.OC.SafetyNAlert.service.URL.IPhoneAlertService;

@WebMvcTest(controllers = PhoneAlertController.class)
public class PhoneAlertControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IPhoneAlertService service;

	private String Station = "1";


	@Test
	public void testGetPhoneAlert() throws Exception {
		mockMvc.perform(get("/phone").param("Station", Station)).andExpect(status().isOk());

	}

}
