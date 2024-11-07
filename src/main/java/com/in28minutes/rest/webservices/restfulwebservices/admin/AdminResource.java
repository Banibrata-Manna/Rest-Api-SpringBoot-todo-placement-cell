package com.in28minutes.rest.webservices.restfulwebservices.admin;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasRole('ADMIN')")
public class AdminResource {
private AdminRepository repository;
	
	public AdminResource (AdminRepository repository) {
		this.repository = repository;
	}
	@GetMapping("/admins")
	public List<Admin> getAllHods() {
		return repository.findAll();
	}	
}
