package com.OC.SafetyNAlert.repository;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.OC.SafetyNAlert.model.JsonFile;
import com.OC.SafetyNAlert.model.Person;

public interface JsonFileRepo extends JpaRepository<JsonFile,Long> {

	Person save(Person person);
	
	//List <Person> deleteByFirstName(String firstName);


	/*
	@Transactional
	@Modifying
	void deleteBylastNameandfirstName(String lastName, String firstName);
	*/


	


}
