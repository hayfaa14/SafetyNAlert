package com.OC.SafetyNAlert.controller.URL;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.OC.SafetyNAlert.model.Person;
import com.OC.SafetyNAlert.service.URL.IChildAlertService;

import DTO.Child;

@RestController
public class ChildAlertController {
	
	@Autowired
	private IChildAlertService service;
	
	@GetMapping("childAlert")
	public List<Child> getChildAlert(@RequestParam String address) throws ParseException{
		return service.getChildAlert(address);
	}

}
