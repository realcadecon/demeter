package com.callisto.demeter.dao;

import com.callisto.demeter.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> findAll();

    User findUserByID(int id);

    void saveUser(User user);

    void deleteUserByID(int id);
}
