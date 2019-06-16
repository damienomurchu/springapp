package com.example.springapp.service.impl;

import com.example.springapp.model.Friendship;
import com.example.springapp.model.Person;
import com.example.springapp.repository.FriendshipRepository;
import com.example.springapp.repository.PersonRepository;
import com.example.springapp.service.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("friendshipService")
public class FriendshipServiceImpl implements FriendshipService {

  @Autowired
  private FriendshipRepository friendshipRepository;

  @Autowired
  private PersonRepository personRepository;


  @Override
  public Friendship newFriendship(Friendship friendship) {
    Friendship newFriendship = new Friendship(friendship.getSourceUserId(), friendship.getTargetUserId());
    return friendshipRepository.save(newFriendship);
  }

  // helper to fetch all friendships
  public List<Friendship> getAllFriendships() {
    return friendshipRepository.findAll();
  }

  // helper to get ids of your friends from a list of friendships
  public List<Long> getFriendIds(List<Friendship> friendships, Long userId) {
    List<Long> friendIds = new ArrayList<Long>();

    // check list of friendships for your friendships
    for (Friendship friendship : friendships) {
      if (friendship.getSourceUserId() == userId) {
        friendIds.add(friendship.getTargetUserId());
      }
    }
    return friendIds;
  }

  // helper to return Person by id
  public ArrayList<Person> getPersonsById(List<Long> PersonIds) {
    ArrayList<Person> persons = new ArrayList<>();
    for (Long friendId : PersonIds) {
      Person person = personRepository.findById(friendId).orElseGet(null);
      if (person != null) {
        persons.add(person);
      }
    }
    return persons;
  }

  @Override
  public ArrayList<Person> getFriends(Long userId) {

    // fetch all friendships
    List<Friendship> friendships = getAllFriendships();

    // fetch ids of your friends
    List<Long> friendIds = getFriendIds(friendships, userId);

    // fetch friends from their ids
    ArrayList<Person> friends = getPersonsById(friendIds);

    return friends;
  }

  @Override
  public ArrayList<Person> getFriendSuggestions(Long userId) {
    // get your friends
    ArrayList<Person> friends = getFriends(userId);

    // get their friends
    ArrayList<Long> suggestedFriendIds = new ArrayList<>();
    for (Person friend : friends) {
      suggestedFriendIds.add(friend.getId());
    }

    // ensure suggestions don't contain any dupes or the originating user
    HashSet<Long> cleanedSuggestions = new HashSet<>(suggestedFriendIds);
    cleanedSuggestions.remove(userId);

    ArrayList<Person> suggestedFriends = getPersonsById(new ArrayList<>(cleanedSuggestions));

    return suggestedFriends;
  }

  @Override
  public Map<String, ArrayList<Person>> getFriendSuggestionsByLocation(Long userId) {

    Map<String, ArrayList<Person>> suggestionsByLocation = new TreeMap<String, ArrayList<Person>>();

    // get suggested friends
    ArrayList<Person> suggestedFriends = getFriendSuggestions(userId);

    for (Person friend : suggestedFriends) {
      String location = friend.getCity();

      // check if map contains a key for that city
      boolean containsLocation = suggestionsByLocation.containsKey(location);

      if (!containsLocation) {
        // if not add a location key and the person
        ArrayList<Person> friends = new ArrayList<Person>();
        friends.add(friend);
        suggestionsByLocation.put(location, friends);
      } else {
        // add the person to the array for that location
        suggestionsByLocation.get(location).add(friend);
      }
    }

    return suggestionsByLocation;
  }
}
