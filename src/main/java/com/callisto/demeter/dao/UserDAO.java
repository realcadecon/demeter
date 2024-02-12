package com.callisto.demeter.dao;

import com.callisto.demeter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Integer> {

    @Query("SELECT i FROM User i JOIN FETCH i.meals WHERE i.id = ?1")
    User findUserAndMealsByIdJoinFetch(int id);

    @Query("SELECT u FROM User u WHERE u.id in ?1")
    List<User> findUsersById(String ids);

    @Query("SELECT u FROM User u WHERE u.username =?1 and u.enabled = 1")
    User findByUsername(String username);
}
