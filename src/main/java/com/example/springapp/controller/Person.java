package com.example.springapp.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Person", schema = "springapp")
public class User extends KeyEntity {

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

  public User(String name, String city, Long[] friends) {
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
