package com.in28minutes.rest.webservices.restfulwebservices.student;

import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentResource {
	
	StudentRepository repository;
	
	public StudentResource(StudentRepository repository) {
		this.repository = repository;
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