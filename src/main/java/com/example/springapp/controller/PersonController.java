package com.example.springapp.controller;

import com.example.springapp.model.Person;
import com.example.springapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.springapp.utils.ValidationHelper.isValidString;

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
    // TODO handle cases where null
    return personService.getPerson(userId);
  }

  /**
   * Creates a new Person in system
   *
   * @param person Person to create
   * @return person that was created
   */
  @RequestMapping(method = RequestMethod.POST, value = "/person")
  public ResponseEntity<Person> newPerson(@RequestBody Person person) {
    String name = person.getName();
    String city = person.getCity();

    // handle bad, malformed, and absent fields in input
    if (!isValidString(name) || !isValidString(city)) {
      return new ResponseEntity(null, null, HttpStatus.NOT_ACCEPTABLE);
    }

    Person newPerson = new Person(name, city);
    Person createdPerson = personService.newPerson(newPerson);
    return new ResponseEntity(createdPerson, null, HttpStatus.CREATED);
  }

}
