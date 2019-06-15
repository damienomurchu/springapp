package com.example.springapp.service;

import com.example.springapp.controller.Friendship;

import java.util.List;

public interface FriendshipService {

  Friendship newFriendship(Friendship newFriendship);

  List<Friendship> getFriends(String userId);

  List<Friendship> getFriendSuggestions(String userId);

  List<Friendship> getFriendSuggestionsByLocation(String userId);

}
