package com.example.springapp.service.impl;

import com.example.springapp.controller.Person;
import com.example.springapp.repositories.PersonRepository;
import com.example.springapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PersonServiceImpl implements PersonService{

  @Autowired
  private PersonRepository personRepository;


  @Override
  public Person newPerson(Person person) {
    Person newPerson = new Person(person.getName(), person.getCity());
    return personRepository.save(newPerson);
  }

  @Override
  public Optional<Person> getPerson(Long userId) {
    return personRepository.findById(userId);
  }
}
