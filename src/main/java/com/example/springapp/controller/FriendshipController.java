package com.example.springapp.controller;

import com.example.springapp.model.Friendship;
import com.example.springapp.model.Person;
import com.example.springapp.service.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class FriendshipController {

  @Autowired
  private FriendshipService friendshipService;

  @RequestMapping(method = RequestMethod.POST, value = "/friendship")
  public Friendship newFriendship(@RequestBody Friendship newFriendship) {
    return friendshipService.newFriendship(newFriendship);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/friendship/{userId}")
  public ArrayList<Person> getFriends(@PathVariable(value = "userId") Long userId) {
    return friendshipService.getFriends(userId);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/friendship/{userId}/suggestions")
  public ArrayList<Person> getFriendSuggestions(@PathVariable(value = "userId") Long userId) {
    return (ArrayList<Person>) friendshipService.getFriendSuggestions(userId);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/friendship/{userId}/suggestions/bylocation")
  public ArrayList<Person> getFriendSuggestionsByLocation(@PathVariable(value = "userId") Long userId) {
    return (ArrayList<Person>) friendshipService.getFriendSuggestionsByLocation(userId);
  }


}
