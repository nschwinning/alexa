package de.bich.alexa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.bich.alexa.model.TwitterStatus;
import de.bich.alexa.service.TwitterStatusService;
import de.bich.alexa.twitter.TwitterHandler;
import twitter4j.TwitterException;

@RestController
public class ScherbenController {
	
	@Autowired
	private TwitterStatusService service;

	@GetMapping(value="/scherben")
	public TwitterStatus getTweets() throws TwitterException{
		return TwitterHandler.getLatestStatusByUser("Scherben81");
	}
	
}
