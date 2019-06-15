package com.example.springapp.service;

import com.example.springapp.controller.Friendship;

import java.util.List;

public interface FriendshipService {

  Friendship newFriendship(Friendship newFriendship);

  List<Friendship> getFriends(Long userId);

  List<Friendship> getFriendSuggestions(Long userId);

  List<Friendship> getFriendSuggestionsByLocation(Long userId);

}
