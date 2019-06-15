package com.example.springapp.service;

import com.example.springapp.controller.Friendship;
import com.example.springapp.controller.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface FriendshipService {

  Friendship newFriendship(Friendship newFriendship);

  ArrayList<Person> getFriends(Long userId);

  ArrayList<Person> getFriendSuggestions(Long userId);

  Map<String, ArrayList<Person>> getFriendSuggestionsByLocation(Long userId);

}
