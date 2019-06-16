package com.example.springapp.service.impl;

import com.example.springapp.model.Person;
import com.example.springapp.repository.PersonRepository;
import com.example.springapp.service.FriendshipService;
import com.example.springapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Implementation to PersonService to handle Person-related operations
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {

  /**
   * PersonRepository to interact with DB
   */
  @Autowired
  private PersonRepository personRepository;

  /**
   * FriendshipService to handle Friendship-related operations
   */
  @Autowired
  private FriendshipService friendshipService;


  /**
   * Creates a new Person and persists it to the DB
   *
   * @param person Person to create
   * @return new Person created
   */
  @Override
  public Person newPerson(Person person) {
    Person newPerson = new Person(person.getName(), person.getCity());
    return personRepository.save(newPerson);
  }

  /**
   * Fetches a Person by their ID
   *
   * @param userId ID of Person to fetch
   * @return Person that matches ID or
   */
  @Override
  public Person getPerson(Long userId) {
    Optional<Person> foundPerson = personRepository.findById(userId);
    if (foundPerson.isPresent()) {
      Person nonNullUser = foundPerson.get();
      ArrayList<Long> friends = friendshipService.getFriendsIds(userId);
      Long[] friendIds = new Long[friends.size()];
      friendIds = friends.toArray(friendIds);
      nonNullUser.setFriends(friendIds);
      return nonNullUser;
    }

    return null;
  }
}
