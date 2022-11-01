package com.OC.SafetyNAlert.Controller.URL;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.OC.SafetyNAlert.controller.URL.FloodController;
import com.OC.SafetyNAlert.service.URL.FloodService;

@WebMvcTest(controllers = FloodController.class)
public class FloodControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private FloodService service;
	
	private String station = "1";
	
	@Test
	public void testGetHouseholds() throws Exception{
		
		mockMvc.perform(get("/flood").param("station", station)).andExpect(status().isOk());
		
	}
	

}
