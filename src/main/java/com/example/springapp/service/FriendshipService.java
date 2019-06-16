package com.example.springapp.service;

import com.example.springapp.model.Friendship;
import com.example.springapp.model.Person;

import java.util.ArrayList;
import java.util.Map;

/**
 * Defines the contract that all PersonService implementations must meet
 */
public interface FriendshipService {

  /**
   * Checks if friendship already exists between two users
   *
   * @param userId ID of the first person
   * @param friendId ID of the second person
   * @return true if already friends, false if not
   */
  boolean isFriend(Long userId, Long friendId);

  /**
   * Method to create a new Friendship
   *
   * @param newFriendship Friendship to create
   * @return new Friendship created
   */
  Friendship newFriendship(Friendship newFriendship);

  /**
   * Method to get friends of a person
   *
   * @param userId ID of Person to get friends for
   * @return List of friends
   */
  ArrayList<Person> getFriends(Long userId);

  /**
   * Method to get IDs of friends of a person
   *
   * @param userId ID of person to fetch friends
   * @return List of IDs of friends
   */
  ArrayList<Long> getFriendsIds(Long userId);

  /**
   * Method to get list of suggested friends for a user
   *
   * @param userId ID of Person to get friend suggestions for
   * @return List of suggested friends
   */
  ArrayList<Person> getFriendSuggestions(Long userId);

  /**
   * Method to get list of suggested friends for a user, mapped by location
   *
   * @param userId ID of Person to get friend suggestions for
   * @return Suggested friends mapped by location
   */
  Map<String, ArrayList<Person>> getFriendSuggestionsByLocation(Long userId);

}
