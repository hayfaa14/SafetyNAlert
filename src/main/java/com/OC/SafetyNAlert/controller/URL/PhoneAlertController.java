package com.OC.SafetyNAlert.controller.URL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.OC.SafetyNAlert.service.URL.IPhoneAlertService;



@RestController
public class PhoneAlertController {
	@Autowired
	IPhoneAlertService phoneService;
	
	@GetMapping("phone")
	public List<String> getPhoneAlert(@RequestParam String Station){
		return phoneService.getPhoneNumbersByStation(Station);
	}

}
