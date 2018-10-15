package de.bich.alexa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.bich.alexa.model.TwitterStatus;
import de.bich.alexa.service.TwitterStatusService;

@RestController
public class ScherbenController {
	
	@Autowired
	private TwitterStatusService service;

	@GetMapping(value="/scherben")
	public List<TwitterStatus> getTweets(){
		List<TwitterStatus> statusList = service.findAll();
		return statusList;
	}
	
}
