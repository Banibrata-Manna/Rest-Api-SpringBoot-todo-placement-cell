package com.in28minutes.rest.webservices.restfulwebservices.hods;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HodRepository extends JpaRepository<Hod, String>{

}
