package com.OC.SafetyNAlert.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.OC.SafetyNAlert.model.JsonFile;
import com.OC.SafetyNAlert.service.JsonFileService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class JsonFileController {
	
	@Autowired private JsonFileService jsonFileService;
	
	@ResponseBody
	@GetMapping("/jsonFile")
	public Iterable<JsonFile> getJsonFile() throws IOException,JsonProcessingException{
		return jsonFileService.getJsonFile();
	}
	
}
