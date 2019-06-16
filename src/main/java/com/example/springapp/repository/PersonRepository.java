package com.example.springapp.repository;

import com.example.springapp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PersonRepository to interact with DB for Person-related operations
 */
@Repository("personRepository")
public interface PersonRepository extends JpaRepository<Person, Long> {

}
