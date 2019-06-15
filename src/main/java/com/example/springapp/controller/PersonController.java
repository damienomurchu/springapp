package com.example.springapp.controller;

import com.example.springapp.service.PersonService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController implements PersonService {

    @Override
    public Person newPerson(Person newPerson) {
        // TODO implement
        return null;
    }

}
