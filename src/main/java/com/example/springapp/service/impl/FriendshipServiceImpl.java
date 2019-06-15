package com.example.springapp.service.impl;

import com.example.springapp.controller.Friendship;
import com.example.springapp.repositories.FriendshipRepository;
import com.example.springapp.service.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FriendshipServiceImpl implements FriendshipService {

  @Autowired
  private FriendshipRepository friendshipRepository;


  @Override
  public Friendship newFriendship(Friendship newFriendship) {
    // TODO implement
    return null;
  }

  @Override
  public List<Friendship> getFriends(String userId) {
    // TODO implement
    return null;
  }

  @Override
  public List<Friendship> getFriendSuggestions(String userId) {
    // TODO implement
    return null;
  }

  @Override
  public List<Friendship> getFriendSuggestionsByLocation(String userId) {
    // TODO implement
    return null;
  }
}
