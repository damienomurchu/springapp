package com.example.springapp.controller;

import com.example.springapp.model.Person;
import com.example.springapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller to handle incoming person-related requests
 */
@RestController
public class PersonController {

  /**
   * PersonService to handle Person-related operations
   */
  @Autowired
  private PersonService personService;

  /**
   * Fetch Person that matches ID requested
   *
   * @param userId ID of Person to fetch
   * @return person that was retrieved
   */
  @RequestMapping(method = RequestMethod.GET, value = "/person/{userId}")
  public Person getPerson(@PathVariable(value = "userId") Long userId) {
    return personService.getPerson(userId);
  }

  /**
   * Creates a new Person in system
   *
   * @param newPerson Person to create
   * @return person that was created
   */
  @RequestMapping(method = RequestMethod.POST, value = "/person")
  public Person newPerson(@RequestBody Person newPerson) {
    return personService.newPerson(newPerson);
  }

}
