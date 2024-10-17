package com.in28minutes.rest.webservices.restfulwebservices.student;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException(String message) {
		super(message);
	}

}
//@ResponseStatus(code = HttpStatus.NOT_FOUND)
//public class UserNotFoundException extends RuntimeException {
//	
//	public UserNotFoundException(String message) {
//		super(message);
//	}
//	
//}