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

    @RequestMapping("/user/{id}/friends")
    public ArrayList<Person> getFriends(@PathVariable(value = "id") Long userId) {
        // TODO implement
        return null;
    }

    @RequestMapping("/user/{id}/friend/suggestions")
    public ArrayList<Person> getFriendSuggestions(@PathVariable(value = "id") Long userId) {
        // TODO implement
        return null;
    }

    @RequestMapping("/user/{id}/friend/suggestions/bylocation")
    public ArrayList<Person> getFriendSuggestionsByLocation(@PathVariable(value = "id") Long userId) {
        // TODO implement
        return null;
    }


}
