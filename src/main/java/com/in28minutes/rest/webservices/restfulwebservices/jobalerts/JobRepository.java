package com.in28minutes.rest.webservices.restfulwebservices.jobalerts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, String> {
}
