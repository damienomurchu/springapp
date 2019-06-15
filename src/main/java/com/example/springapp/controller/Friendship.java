package com.example.springapp.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Friendship", schema = "springapp")
public class Friendship extends KeyEntity {

  @Column(nullable = false)
  private Long sourceUserId;

  @Column(nullable = false)
  private Long targetUserId;

  public Friendship(Long sourceUserId, Long targetUserId) {
    this.sourceUserId = sourceUserId;
    this.targetUserId = targetUserId;
  }

  public Long getSourceUserId() {
    return sourceUserId;
  }

  public Long getTargetUserId() {
    return targetUserId;
  }
}
