package com.in28minutes.rest.webservices.restfulwebservices.admin;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
	Optional<Admin> findByEmail(String email);
}
