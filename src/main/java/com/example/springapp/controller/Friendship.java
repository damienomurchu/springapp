package com.example.springapp.controller;

public class Friendship {
  private Long sourceUserId;
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
