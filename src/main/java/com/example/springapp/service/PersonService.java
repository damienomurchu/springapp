package com.example.springapp.service;

import com.example.springapp.model.Person;

public interface PersonService {

  Person newPerson(Person newPerson);

  Person getPerson(Long userId);

}
