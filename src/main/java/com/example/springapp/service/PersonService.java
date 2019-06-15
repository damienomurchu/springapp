package com.example.springapp.service;

import com.example.springapp.controller.Person;

import java.util.Optional;

public interface PersonService {

  Person newPerson(Person newPerson);

  Optional<Person> getPerson(Long userId);

}
