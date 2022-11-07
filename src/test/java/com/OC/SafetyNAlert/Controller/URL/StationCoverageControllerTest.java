package com.OC.SafetyNAlert.Controller.URL;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.OC.SafetyNAlert.controller.URL.StationCoverageController;
import com.OC.SafetyNAlert.service.URL.IStationCoverageService;

@WebMvcTest(controllers = StationCoverageController.class)
public class StationCoverageControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IStationCoverageService service;

	private String station = "1";


	@Test
	public void testGetStationCoverage() throws Exception {
		mockMvc.perform(get("/firestation").param("station", station)).andExpect(status().isOk());

	}

}
