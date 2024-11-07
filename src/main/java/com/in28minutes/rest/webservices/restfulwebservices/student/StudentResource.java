package com.in28minutes.rest.webservices.restfulwebservices.student;

import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.jobalerts.Job;
import com.in28minutes.rest.webservices.restfulwebservices.jobalerts.JobRepository;
import com.in28minutes.rest.webservices.restfulwebservices.jobalerts.JobService;

@RestController
public class StudentResource {
	
	private StudentRepository repository;
	private JobService jobService;
	private StudentService studentService;
	
	public StudentResource(StudentRepository repository
			,JobService jobService, StudentService studentService) {
		this.repository = repository;
		this.jobService = jobService;
		this.studentService = studentService;
	}
	
	@GetMapping("/students/{enrollment-number}")
	public EntityModel<Student> retrieveStudent(@PathVariable("enrollment-number") String enrollmentNumber) {
		Optional<Student> student = repository.findById(enrollmentNumber);
		
		if(student.isEmpty()) {
			throw new StudentNotFoundException("Student Not Found!");
		}
		
		EntityModel<Student> model = EntityModel.of(student.get());
		
		return model;
	}
	@GetMapping("/students/{enrollment-number}/jobs")
	public List<Job> getJobs(
			@PathVariable("enrollment-number") String enrollmentNumber) {
		return jobService.getAllJobs();			
	}
	@PostMapping("/students/{enrollment-number}/jobs/{job-id}")
	public void applyJob(
			@PathVariable("enrollment-number") String enrollmentNumber,
			@PathVariable("job-id") String jobId) {
		studentService.apply(enrollmentNumber, jobId);
	}
}
//@GetMapping("/jpa/users/{user-id}")
//public EntityModel<User> retrieveUser(@PathVariable("user-id") int id) {
//	
//	Optional<User> user = userRepository .findById(id);
//	
//	if(user.isEmpty()) {
//		throw new UserNotFoundException("User not found!");
//	}
//	
//	EntityModel<User> model = EntityModel.of(user.get());
//	
//	WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
//	
//	model.add(link.withRel("all-users"));
//	
//	return model;
//}