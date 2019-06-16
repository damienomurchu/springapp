package com.example.springapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Person model to represent a user in our system
 */
@Entity
@Table(name = "Person", schema = "springapp")
public class Person extends KeyModel {

  /**
   * Name of Person
   */
  @Column(nullable = false)
  private String name;

  /**
   * Location of person
   */
  @Column(nullable = false)
  private String city;

  /**
   * List of friends by id for person
   */
  @Column(nullable = true)
  private Long[] friends;

  /**
   * Creates a new Person
   *
   * @param name Name of person
   * @param city City of person
   */
  public Person(String name, String city) {
    this.name = name;
    this.city = city;
  }

  /**
   * Creates a new Person
   *
   * @param name Name of person
   * @param city City of person
   * @param friends List of friend ids of person
   */
  public Person(String name, String city, Long[] friends) {
    this.name = name;
    this.city = city;
    this.friends = friends;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Long[] getFriends() {
    return friends;
  }

  public void setFriends(Long[] friends) {
    this.friends = friends;
  }
}
