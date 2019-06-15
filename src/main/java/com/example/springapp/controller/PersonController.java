package com.example.springapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public Person addUser(@RequestBody Person newPerson) {
        // TODO implement
        return null;
    }


}
