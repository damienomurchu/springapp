package com.example.springapp.service;

import com.example.springapp.model.Friendship;
import com.example.springapp.model.Person;

import java.util.ArrayList;
import java.util.Map;

public interface FriendshipService {

  Friendship newFriendship(Friendship newFriendship);

  ArrayList<Person> getFriends(Long userId);

  ArrayList<Person> getFriendSuggestions(Long userId);

  Map<String, ArrayList<Person>> getFriendSuggestionsByLocation(Long userId);

}
