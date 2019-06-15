package com.example.springapp.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class FriendshipController {

    @RequestMapping(method = RequestMethod.POST, value = "/friendship")
    public Friendship newFriendship(@RequestBody Friendship newFriendship) {
        // TODO implement
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/friendship/{userId}")
    public ArrayList<Person> getFriends(@PathVariable(value = "userId") String userId) {
        // TODO implement
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/friendship/{userId}/suggestions")
    public ArrayList<Person> getFriendSuggestions(@PathVariable(value = "userId") String userId) {
        // TODO implement
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/friendship/{userId}/suggestions/bylocation")
    public ArrayList<Person> getFriendSuggestionsByLocation(@PathVariable(value = "userId") String userId) {
        // TODO implement
        return null;
    }


}
