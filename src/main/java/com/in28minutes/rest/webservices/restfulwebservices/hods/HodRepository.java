package com.in28minutes.rest.webservices.restfulwebservices.hods;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HodRepository extends JpaRepository<Hod, String>{
	Optional<Hod> findByEmail(String email);
}
