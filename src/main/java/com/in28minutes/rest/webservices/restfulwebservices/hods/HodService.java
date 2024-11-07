package com.in28minutes.rest.webservices.restfulwebservices.hods;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class HodService {
	private HodRepository repository;
	
	public HodService (HodRepository repository) {
		this.repository = repository;
	}
	
	public List<Hod> getAllHods() {
		return repository.findAll();
	}
}
