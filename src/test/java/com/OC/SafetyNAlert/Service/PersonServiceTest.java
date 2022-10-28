
package com.OC.SafetyNAlert.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.OC.SafetyNAlert.Shared.Result;
import com.OC.SafetyNAlert.model.Person;
import com.OC.SafetyNAlert.repository.JsonFileRepo;
import com.OC.SafetyNAlert.service.IPersonService;
import com.OC.SafetyNAlert.service.PersonService;

@ExtendWith(MockitoExtension.class)

public class PersonServiceTest {
	
	private IPersonService personService;
	
	//Mock repository
	@Mock
	JsonFileRepo reader;
	
	List<Person> expectedPersonsList = new ArrayList<>();
	
	@BeforeEach
	public void setUp() throws IOException {
		expectedPersonsList.add(new Person("Franck","Ribery","5 rue du quai", "Lyon", "69000", "123456", "ribery@bayern.com"));
		expectedPersonsList.add(new Person("Alphonso","Davies","5 rue du fleuve", "Munich", "43690","1234567", "davies@bayern.com"));
		expectedPersonsList.add(new Person("Thomas","Muller","5 rue du pont", "berlin",  "56798","12345678", "thomas@bayern.com"));
		expectedPersonsList.add(new Person("Sadio","Mane","5 rue du banc","Dakar", "90874", "123456789",  "sadio@bayern.com"));
		when(reader.readPerson()).thenReturn(expectedPersonsList);
		personService=new PersonService(reader);
	}
	
	@Test
	public void testGetPersons() {
		
		List <Person> actualPersons = personService.getPersons();
		assertEquals(actualPersons,expectedPersonsList);
	}
	
	@Test
	public void testAddPerson() {
	Person personToAdd =new Person("Manuel","Neuer","5 rue du stade","543210","Munich","87906", "manuel@gmail.com");
	Person personAdded=personService.savePerson(personToAdd);
	assertEquals(personAdded,personToAdd);
	}
	
	@Test
	public void testUpdatePerson() {
		
		Person person = new Person("Franck","Ribery","2 rue des oiseaux","Lyon","69000","123456","ribery@bayern.com");
		Result testResult=personService.updatePerson(person, "Franck", "Ribery");
		assertEquals(Result.success,testResult);
		
	}
	
	@Test
	public void testDeletePerson() {
		Result result=personService.deletePerson("Franck", "Ribery");
		assertEquals(Result.success,result);
		
	}
	

}
