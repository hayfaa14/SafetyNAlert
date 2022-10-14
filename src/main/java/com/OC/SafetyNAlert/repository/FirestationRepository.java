package com.OC.SafetyNAlert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OC.SafetyNAlert.model.Firestation;

@Repository
public interface FirestationRepository extends JpaRepository<Firestation,Long> {

}
