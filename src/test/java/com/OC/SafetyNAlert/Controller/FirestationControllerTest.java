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
import com.OC.SafetyNAlert.controller.FirestationController;
import com.OC.SafetyNAlert.model.Firestation;
import com.OC.SafetyNAlert.model.Person;
import com.OC.SafetyNAlert.service.FirestationService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = FirestationController.class)
public class FirestationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FirestationService service;

	@Test
	void getFirestationsTest() throws Exception {
		mockMvc.perform(get("/firestations")).andExpect(status().isOk());

	}
	
	
	@Test
	public void addFirestation() throws Exception {
		Firestation firestation= new Firestation("4");
		firestation.addAddress("1 rue du Taur");
		
		ObjectMapper objectMapper = new ObjectMapper();
		String inputJson=objectMapper.writeValueAsString(firestation);
		MvcResult result=mockMvc.perform(MockMvcRequestBuilders.post("/firestation").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(inputJson)).andReturn();
		   int status = result.getResponse().getStatus();
		   assertEquals(200, status);
			
	}
	
	@Test
	public void updateFirestationTest() throws Exception{
		String uri="/firestation/4";
		Firestation firestation = new Firestation("4");
		firestation.setAddress("79 avenue de la gloire");
		ObjectMapper objectMapper = new ObjectMapper();
		String inputJson=objectMapper.writeValueAsString(firestation);
		MvcResult result=mockMvc.perform(MockMvcRequestBuilders.put(uri).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(inputJson)).andReturn();
		   int status = result.getResponse().getStatus();
		   assertEquals(200, status);
		
	}
	
	   @Test
	   public void deleteFirestationByStationOrAddressTest() throws Exception {
	      String uri = "/firestation/delete/79 avenue de la gloire";
	      MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);

	   }
	
	
	
	


}
