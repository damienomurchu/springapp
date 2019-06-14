package com.example.springapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

  @Column(nullable = false)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String city;

  @Column(nullable = false)
  private Long[] friends;

  public User(String name, String city) {
    this.name = name;
    this.city = city;
  }

  public User(Long id, String name, String city, Long[] friends) {
    this.id = id;
    this.name = name;
    this.city = city;
    this.friends = friends;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
