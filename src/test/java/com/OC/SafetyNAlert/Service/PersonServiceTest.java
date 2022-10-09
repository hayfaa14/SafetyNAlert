
package com.OC.SafetyNAlert.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.OC.SafetyNAlert.Shared.Result;
import com.OC.SafetyNAlert.model.Person;
import com.OC.SafetyNAlert.repository.PersonRepository;
import com.OC.SafetyNAlert.service.IPersonService;
import com.OC.SafetyNAlert.service.PersonService;

@ExtendWith(MockitoExtension.class)

public class PersonServiceTest {
	
	private IPersonService personService;
	
	//Mock repository
	@Mock
	PersonRepository personRepo;
	
	List<Person> expectedPersonsList = new ArrayList<>();
	
	@BeforeEach
	public void setUp() throws IOException {
		expectedPersonsList.add(new Person("Franck","Ribery","5 rue du quai", "123456", "Lyon", "69000", "ribery@bayern.com"));
		expectedPersonsList.add(new Person("Alphonso","Davies","5 rue du fleuve", "1234567", "Munich", "43690", "davies@bayern.com"));
		expectedPersonsList.add(new Person("Thomas","Muller","5 rue du pont", "12345678", "berlin", "56798", "thomas@bayern.com"));
		expectedPersonsList.add(new Person("Sadio","Mane","5 rue du banc", "123456789", "Dakar", "90874", "sadio@bayern.com"));
		Mockito.lenient().when(personRepo.findAll()).thenReturn(expectedPersonsList);
		personService=new PersonService(personRepo);
	}
	
	@Test
	public void testGetPersons() {
		
		List <Person> actualPersons = personService.getPersonList();
		assertEquals(actualPersons,expectedPersonsList);
	}
	
	@Test
	public void testAddPerson() {
	Person personToAdd =new Person("Manuel","Neuer","5 rue du stade","543210","Munich","87906", "manuel@gmail.com");
	Person personAdded=personService.addPerson(personToAdd);
	assertEquals(personAdded,personToAdd);
	}
	
	@Test
	public void testUpdatePerson() {}
	
	@Test
	public void testDeletePerson() {
		Result result=personService.deletePerson("Franck", "Ribery");
		assertEquals(Result.success,result);
		
	}
	

}

