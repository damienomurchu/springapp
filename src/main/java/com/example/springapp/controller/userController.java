package com.example.springapp.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import com.example.springapp.model.User;
import com.example.springapp.model.Friendship;

@RestController
public class userController {

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public User addUser(@RequestBody User newUser) {
        // TODO implement
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/friendship")
    public Friendship addFriendship(@RequestBody Friendship newFriendship) {
        // TODO implement
        return null;
    }

    @RequestMapping("/user/{id}/friends")
    public ArrayList<User> getFriends(@PathVariable(value = "id") Long userId) {
        // TODO implement
        return null;
    }

    @RequestMapping("/user/{id}/friend/suggestions")
    public ArrayList<User> getFriendSuggestions(@PathVariable(value = "id") Long userId) {
        // TODO implement
        return null;
    }

    @RequestMapping("/user/{id}/friend/suggestions/bylocation")
    public ArrayList<User> getFriendSuggestionsByLocation(@PathVariable(value = "id") Long userId) {
        // TODO implement
        return null;
    }

}
