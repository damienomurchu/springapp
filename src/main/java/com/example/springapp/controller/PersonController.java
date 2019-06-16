package com.example.springapp.controller;

import com.example.springapp.model.Person;
import com.example.springapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController implements PersonService {

  @Autowired
  private PersonService personService;

  @RequestMapping(method = RequestMethod.GET, value = "/person/{userId}")
  public Person getPerson(@PathVariable(value = "userId") Long userId) {
    return personService.getPerson(userId);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/person")
  public Person newPerson(@RequestBody Person newPerson) {
    return personService.newPerson(newPerson);
  }

}
