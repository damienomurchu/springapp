package com.example.springapp.model;

import javax.persistence.*;

/**
 * Key model class to centralise implementation of DB keys
 */
@MappedSuperclass
public class KeyModel {

  /**
   * Unique id value to represent model
   */
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", unique = true)
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
