package com.in28minutes.rest.webservices.restfulwebservices.hods;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasRole('HOD')")
public class HodResource {
	private HodService service;
	
	public HodResource (HodService service) {
		this.service = service;
	}
	@GetMapping("/hods")
	public List<Hod> getAll() {
		return service.getAllHods();
	}
}
