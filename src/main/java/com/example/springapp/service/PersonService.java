package com.example.springapp.service;

import com.example.springapp.model.Person;

import java.util.Optional;

/**
 * Defines the contract that all PersonService implementations must meet
 */
public interface PersonService {

  /**
   * @param newPerson Person to create
   * @return new Person created
   */
  Person newPerson(Person newPerson);

  /**
   * @param userId ID of Person to fetch
   * @return Person that matches ID
   */
  Person getPerson(Long userId);

}
