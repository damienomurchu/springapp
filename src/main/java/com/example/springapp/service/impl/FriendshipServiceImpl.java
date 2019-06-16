package com.example.springapp.service.impl;

import com.example.springapp.model.Friendship;
import com.example.springapp.model.Person;
import com.example.springapp.repository.FriendshipRepository;
import com.example.springapp.repository.PersonRepository;
import com.example.springapp.service.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Implementation to FriendshipService to handle Friendship-related operations
 */
@Service("friendshipService")
public class FriendshipServiceImpl implements FriendshipService {

  /**
   * FriendshipRepository to interact with DB Friendship entities
   */
  @Autowired
  private FriendshipRepository friendshipRepository;

  /**
   * PersonRepository to interact with DB Person entities
   */
  @Autowired
  private PersonRepository personRepository;


  /**
   * Creates a new Friendship and persists it to the DB
   *
   * @param friendship Friendship to create
   * @return Friendship saved to DB
   */
  @Override
  public Friendship newFriendship(Friendship friendship) {
    Long userId = friendship.getSourceUserId();
    Long friendId = friendship.getTargetUserId();

    // check if friendship already exists
    boolean isFriend = isFriend(userId, friendId);

    // create Friendship if no pre-existing friendship
    if (!isFriend) {
      Friendship newFriendship = new Friendship(userId, friendId);
      return friendshipRepository.save(newFriendship);
    }

    // TODO return existing friendship if already a friend instead of null
    return null;
  }

  public boolean isFriend(Long userId, Long friendId) {
    ArrayList<Person> existingFriendIds = getFriends(userId);
    return existingFriendIds.contains(friendId);
  }

  /**
   * Helper to fetch all friendships from DB
   *
   * @return List of all friendships
   */
  private List<Friendship> getAllFriendships() {
    return friendshipRepository.findAll();
  }

  /**
   * Helper to get all IDs of your friends from a list of friendships
   *
   * @param friendships List of friendships
   * @param userId ID if user you want to retrieve friend IDs for
   * @return List of IDs of all friends of a person
   */
//  private List<Long> getFriendIds(List<Friendship> friendships, Long userId) {
//    List<Long> friendIds = new ArrayList<Long>();
//
//    // check list of friendships for your friendships
//    for (Friendship friendship : friendships) {
//      // add friendId if you're the source of the friendship
//      if (friendship.getSourceUserId() == userId) {
//        friendIds.add(friendship.getTargetUserId());
//      }
//      // add friendId if you're the target of the friendship
//      if (friendship.getTargetUserId() == userId) {
//        friendIds.add(friendship.getSourceUserId());
//      }
//    }
//
//    return friendIds;
//  }

  /**
   * Helper to return the full Person object(s) for a list of given person IDs
   *
   * @param PersonIds List of person IDs
   * @return List of Person objects that match IDs received
   */
  // helper to return Person by id
  private ArrayList<Person> getPersonsById(List<Long> PersonIds) {
    ArrayList<Person> persons = new ArrayList<>();
    for (Long friendId : PersonIds) {
      Person person = personRepository.findById(friendId).orElseGet(null);
      if (person != null) {
        persons.add(person);
      }
    }
    return persons;
  }

  /**
   * Helper to fetch all IDs of a users friends
   *
   * @param userId ID of user to find their friends
   * @return List of their friends IDs
   */
  private ArrayList<Long> getFriendsIds(Long userId) {
    // fetch all friendships
    List<Friendship> friendships = getAllFriendships();

    // fetch ids of your friends
    ArrayList<Long> friendIds = new ArrayList<Long>();

    // check list of friendships for your friendships
    for (Friendship friendship : friendships) {
      // add friendId if you're the source of the friendship
      if (friendship.getSourceUserId() == userId) {
        friendIds.add(friendship.getTargetUserId());
      }
      // add friendId if you're the target of the friendship
      if (friendship.getTargetUserId() == userId) {
        friendIds.add(friendship.getSourceUserId());
      }
    }

    return friendIds;
  }

  /**
   * Fetch all friends for a specific user
   *
   * @param userId ID of Person to get friends for
   * @return List of friends for person
   */
  @Override
  public ArrayList<Person> getFriends(Long userId) {

    // fetch the IDs of all users friends
    List<Long> friendIds = getFriendsIds(userId);

    // fetch friends from their ids
    ArrayList<Person> friends = getPersonsById(friendIds);

    return friends;
  }

  /**
   * Fetch a list of suggested friends for a user based on the
   * friends of their current friends.
   *
   * @param userId ID of Person to get friend suggestions for
   * @return List of suggested friends
   */
  @Override
  public ArrayList<Person> getFriendSuggestions(Long userId) {
    // get your friends
    ArrayList<Person> friends = getFriends(userId);

    // get their friends
    ArrayList<Long> suggestedFriendIds = new ArrayList<>();
    for (Person friend : friends) {
      ArrayList<Long> friendsFriends = getFriendsIds(friend.getId());
      suggestedFriendIds.addAll(friendsFriends);
    }

    // ensure suggestions don't contain any dupes or the originating user
    HashSet<Long> cleanedSuggestions = new HashSet<>(suggestedFriendIds);
    cleanedSuggestions.remove(userId);

    ArrayList<Person> suggestedFriends = getPersonsById(new ArrayList<>(cleanedSuggestions));

    return suggestedFriends;
  }

  /**
   * Fetch a sorted list of suggested friends for a user based on the
   * friends of their current friends. Sorting is by location.
   *
   * @param userId ID of Person to get friend suggestions for
   * @return Map of suggested friends with location as the key
   */
  @Override
  public Map<String, ArrayList<Person>> getFriendSuggestionsByLocation(Long userId) {

    Map<String, ArrayList<Person>> suggestionsByLocation = new TreeMap<String, ArrayList<Person>>();

    // get suggested friends
    ArrayList<Person> suggestedFriends = getFriendSuggestions(userId);

    for (Person friend : suggestedFriends) {
      String location = friend.getCity();

      // check if map contains a key for that location
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
