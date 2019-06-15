package com.example.springapp.controller;

import com.example.springapp.service.PersonService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController implements PersonService {

    @RequestMapping(method = RequestMethod.GET, value = "/person/{id}")
    public Person getPerson(@PathVariable(value = "id") String userId) {
        // TODO implement
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/person")
    public Person newPerson(@RequestBody Person newPerson) {
        // TODO implement
        return null;
    }

}
