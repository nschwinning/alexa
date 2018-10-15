package de.bich.alexa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.bich.alexa.model.TwitterStatus;
import de.bich.alexa.repositories.TwitterStatusRepository;

@Service	
public class TwitterStatusService {

	@Autowired
	private TwitterStatusRepository repo;
	
	@Transactional
	public List<TwitterStatus> findAll(){
		return repo.findAll();
	}
	
}
