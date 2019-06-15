package com.example.springapp.service;

import com.example.springapp.controller.Friendship;
import com.example.springapp.controller.Person;

import java.util.List;

public interface FriendshipService {

  Friendship newFriendship(Friendship newFriendship);

  List<Person> getFriends(Long userId);

  List<Person> getFriendSuggestions(Long userId);

  List<Person> getFriendSuggestionsByLocation(Long userId);

}
