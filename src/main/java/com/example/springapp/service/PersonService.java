package com.example.springapp.service;

import com.example.springapp.controller.Person;

public interface PersonService {

  Person newPerson(Person newPerson);

  Person getPerson(String userId);

}
