package com.example.springapp.repositories;

import com.example.springapp.controller.Friendship;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier(value = "personRepository")
public interface FriendshipRepository extends JpaRepository<Friendship, Long> {

}
