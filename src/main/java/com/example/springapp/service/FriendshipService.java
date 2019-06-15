package com.example.springapp.service;

import com.example.springapp.controller.Friendship;
import com.example.springapp.controller.Person;

import java.util.List;

public interface FriendshipService {

  Friendship newFriendship(Friendship newFriendship);

  List<Person> getFriends(String userId);

  List<Person> getFriendSuggestions(String userId);

  List<Person> getFriendSuggestionsByLocation(String userId);

}
