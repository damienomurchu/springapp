package com.example.springapp.controller;

import javax.persistence.*;

@MappedSuperclass
public class KeyEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "PK", unique = true)
  private Long id;

  public Long getPk() {
    return id;
  }

  public void setPk(Long id) {
    this.id = id;
  }
}
