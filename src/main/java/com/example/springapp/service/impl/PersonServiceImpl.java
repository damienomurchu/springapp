package com.example.springapp.service.impl;

import com.example.springapp.model.Person;
import com.example.springapp.repository.PersonRepository;
import com.example.springapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("personService")
public class PersonServiceImpl implements PersonService {

  @Autowired
  private PersonRepository personRepository;


  @Override
  public Person newPerson(Person person) {
    Person newPerson = new Person(person.getName(), person.getCity());
    return personRepository.save(newPerson);
  }

  @Override
  public Person getPerson(Long userId) {
    return personRepository.findById(userId).orElseGet(null);
  }
}
