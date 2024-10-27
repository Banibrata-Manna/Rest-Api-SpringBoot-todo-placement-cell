package com.in28minutes.rest.webservices.restfulwebservices.jobalerts;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobResource {
	
	JobService service;
	
	public JobResource(JobService service) {
		this.service = service;
	}
	
	@GetMapping("/jobs")
	public List<Job> getJobs() {
		return service.getAllJobs();			
	}
}
