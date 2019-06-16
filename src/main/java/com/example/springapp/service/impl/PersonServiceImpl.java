package com.example.springapp.service.impl;

import com.example.springapp.model.Person;
import com.example.springapp.repository.PersonRepository;
import com.example.springapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation to PersonService to handle Person-related operations
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {

  /**
   * PersonRepository to interact with DB
   */
  @Autowired
  private PersonRepository personRepository;


  /**
   * Creates a new Person and persists it to the DB
   *
   * @param person Person to create
   * @return new Person created
   */
  @Override
  public Person newPerson(Person person) {
    Person newPerson = new Person(person.getName(), person.getCity());
    return personRepository.save(newPerson);
  }

  /**
   * Fetches a Person by their ID
   *
   * @param userId ID of Person to fetch
   * @return Person that matches ID
   */
  @Override
  public Person getPerson(Long userId) {
    return personRepository.findById(userId).orElseGet(null);
  }
}
