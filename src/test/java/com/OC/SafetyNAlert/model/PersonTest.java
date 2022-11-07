package com.OC.SafetyNAlert.model;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonTest {
	
	@Autowired
	Person person;
	
	@BeforeEach
	public void setUp() {
		person = new Person("Hayfaa","Aukloo","5 rue du boulevard","Lyon","69100","0763874926","hayfaa@email.com");
	}
	
	
	@Test
	public void testSetAge() {
		
		person.setAge(18);
		assertEquals(18,person.getAge());
	}
	
	@Test
	public void testToString() {
		String expectedString = "{\"persons\": [\n        "
				+ "{ \"firstName\":\""+"Hayfaa"+"\", \"lastName\":\""
				+"Aukloo"+"\", \"address\":\""
				+"5 rue du boulevard"+"\", \"city\":\""
				+"Lyon"+"\", \"zip\":\""
				+"69100"+"\", \"phone\":\""
				+"0763874926"+"\", \"email\":\""
				+"hayfaa@email.com"+"\" }\n]}";
		String resultString = person.toString();
		assertEquals(expectedString,resultString);
	}
	
	

}
