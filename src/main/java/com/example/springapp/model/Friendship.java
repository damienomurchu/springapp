package com.example.springapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Friendship model to represent a friendship in our system
 */
@Entity
@Table(name = "Friendship", schema = "springapp")
public class Friendship extends KeyModel implements Serializable {

  /**
   * Id of the source user that initiated the friendship
   */
  @Column(nullable = false)
  private Long sourceUserId;

  /**
   * Id of the target user that was friended
   */
  @Column(nullable = false)
  private Long targetUserId;

  /**
   * Creates a new Friendship
   */
  public Friendship() {
    super();
  }

  /**
   * Creates a new Friendship
   *
   * @param sourceUserId ID of friending user
   * @param targetUserId ID of user being friended
   */
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
