package com.OC.SafetyNAlert.Controller;


import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.OC.SafetyNAlert.controller.PersonController;
import com.OC.SafetyNAlert.model.Person;
import com.OC.SafetyNAlert.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;

@WebMvcTest(controllers = PersonController.class)
public class PersonControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PersonService personService;


	@Test
	void getPersonsTestStatus() throws Exception {
		mockMvc.perform(get("/persons")).andExpect(status().isOk());

	}

	@Test
	public void addPersonTest() throws Exception {
		Person person= new Person();
		person.setFirstName("Hayfaa");
		person.setLastName("Aukloo");
		person.setAddress("Hayfaa");
		person.setPhone("Hayfaa");
		person.setCity("Hayfaa");
		person.setZip("Hayfaa");
		person.setEmail("Hayfaa");
	
		
		ObjectMapper objectMapper = new ObjectMapper();
		String inputJson=objectMapper.writeValueAsString(person);
		MvcResult result=mockMvc.perform(MockMvcRequestBuilders.post("/person").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(inputJson)).andReturn();
		   int status = result.getResponse().getStatus();
		   assertEquals(200, status);
			
	}
	
	@Test
	public void updatePersonTest() throws Exception{
		String uri="/person/Hayfaa/Aukloo";
		Person person = new Person();
		person.setAddress("5 rue du Boulevard");
		ObjectMapper objectMapper = new ObjectMapper();
		String inputJson=objectMapper.writeValueAsString(person);
		MvcResult result=mockMvc.perform(MockMvcRequestBuilders.put(uri).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(inputJson)).andReturn();
		   int status = result.getResponse().getStatus();
		   assertEquals(200, status);
		
	}
	
	   @Test
	   public void deletePersonTest() throws Exception {
	      String uri = "/person/delete/Hayfaa/Aukloo";
	      MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);

	   }
	
	

}
