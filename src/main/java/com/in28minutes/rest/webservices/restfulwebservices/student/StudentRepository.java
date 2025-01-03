package com.in28minutes.rest.webservices.restfulwebservices.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
	Optional<Student> findByEmail(String email);
}
