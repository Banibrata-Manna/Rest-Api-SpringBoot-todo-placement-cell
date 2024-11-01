package com.in28minutes.rest.webservices.restfulwebservices.jobalerts;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@PostMapping("/jobs")
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        Job savedJob = service.saveJob(job);
        return new ResponseEntity<>(savedJob, HttpStatus.CREATED);
    }
}
