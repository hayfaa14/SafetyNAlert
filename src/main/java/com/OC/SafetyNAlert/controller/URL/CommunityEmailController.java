package com.OC.SafetyNAlert.controller.URL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.OC.SafetyNAlert.service.URL.ICommunityEmailService;

@RestController
public class CommunityEmailController {
	
	@Autowired
	private ICommunityEmailService service;
	
	@GetMapping("communityEmail")
	public List<String> getCommunityEmail(@RequestParam String city){
		return service.getCommunityEmail(city);
	}

}
