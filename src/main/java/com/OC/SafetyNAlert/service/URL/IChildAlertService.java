package com.OC.SafetyNAlert.service.URL;

import java.text.ParseException;
import java.util.List;

import com.OC.SafetyNAlert.model.Person;
import com.OC.SafetyNAlert.repository.JsonFileRepo;

import DTO.Child;

public interface IChildAlertService {
	
	List<Child> getChildAlert(String address)throws ParseException;

}
