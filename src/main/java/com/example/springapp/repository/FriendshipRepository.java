package com.example.springapp.repository;

import com.example.springapp.model.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * FriendshipRepository to interact with DB for Person-related operations
 */
@Repository("friendshipRepository")
public interface FriendshipRepository extends JpaRepository<Friendship, Long> {

}
