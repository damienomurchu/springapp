package com.example.springapp.controller;

import com.example.springapp.model.Friendship;
import com.example.springapp.model.Person;
import com.example.springapp.service.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Controller to handle incoming friendship-related requests
 */
@RestController
public class FriendshipController {

  /**
   * FriendshipService to handle Person-related operations
   */
  @Autowired
  private FriendshipService friendshipService;

  /**
   * Creates a new Friendship in system
   *
   * @param newFriendship Friendship to create
   * @return friendship that was created
   */
  @RequestMapping(method = RequestMethod.POST, value = "/friendship")
  public Friendship newFriendship(@RequestBody Friendship newFriendship) {
    return friendshipService.newFriendship(newFriendship);
  }

  /**
   * Fetches all friends for a user
   *
   * @param userId ID of user to fetch friends for
   * @return List of friends
   */
  @RequestMapping(method = RequestMethod.GET, value = "/friendship/{userId}")
  public ArrayList<Person> getFriends(@PathVariable(value = "userId") Long userId) {
    return friendshipService.getFriends(userId);
  }

  /**
   * Fetch a list of suggested friends for user
   *
   * @param userId ID of user to fetch friend suggestions for
   * @return List of suggested friends
   */
  @RequestMapping(method = RequestMethod.GET, value = "/friendship/{userId}/suggestions")
  public ArrayList<Person> getFriendSuggestions(@PathVariable(value = "userId") Long userId) {
    return (ArrayList<Person>) friendshipService.getFriendSuggestions(userId);
  }

  /**
   * Fetch a list of suggested friends sorted by location for user
   *
   * @param userId ID of user to fetch friend suggestions for
   * @return Map of suggested friends with location as the key
   */
  @RequestMapping(method = RequestMethod.GET, value = "/friendship/{userId}/suggestions/bylocation")
  public ArrayList<Person> getFriendSuggestionsByLocation(@PathVariable(value = "userId") Long userId) {
    return (ArrayList<Person>) friendshipService.getFriendSuggestionsByLocation(userId);
  }


}
