package com.in28minutes.rest.webservices.restfulwebservices.student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {

}
