package com.OC.SafetyNAlert.controller.URL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.OC.SafetyNAlert.model.Person;
import com.OC.SafetyNAlert.service.URL.IPersonInfoService;

import DTO.PersonInfo;

@RestController
public class PersonInfoController {
	
	/**
	 * This endpoint is used to display details abouut a person, when searched by a combination of their first name and last name.
	 * The displayed information are: 
	 * 			address
	 * 			age
	 * 			medical records: medication and allergies
	 */
	
	@Autowired
	IPersonInfoService service;
	
	@GetMapping("personInfo")
	public List<PersonInfo> getPersonInfo(@RequestParam String firstName,@RequestParam String lastName){
		return service.getPersonInfo(firstName,lastName);
	}

}
