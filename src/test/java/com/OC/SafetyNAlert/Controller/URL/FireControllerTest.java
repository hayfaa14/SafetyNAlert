package com.OC.SafetyNAlert.Controller.URL;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.OC.SafetyNAlert.controller.URL.FireController;
import com.OC.SafetyNAlert.service.URL.FireService;

@WebMvcTest(controllers = FireController.class)
public class FireControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FireService service;

	private String address = "834 Binoc Ave";

	@Test
	public void testGetResidentsBByAddress() throws Exception {
		mockMvc.perform(get("/fire").param("address", address)).andExpect(status().isOk());

	}
}
