package com.OC.SafetyNAlert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.OC.SafetyNAlert.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long>{
	


}
