package com.callisto.demeter.dao;

import com.callisto.demeter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO {

    //Basic CRUD
    void saveUser(User user);
    void saveUsers(List<User> users);
    User findUserById(int id);
    List<User> findUsersById(List<Integer> ids);
    void updateUser(User user);
    void deleteUserById(int id);

    //Custom
    User findUserAndMealsByIdJoinFetch(int id);

}
