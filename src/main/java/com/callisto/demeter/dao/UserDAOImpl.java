package com.callisto.demeter.dao;

import com.callisto.demeter.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @Override
    public void saveUser(User user) {

    }

    @Override
    public void saveUsers(List<User> users) {

    }

    @Override
    public User findUserById(int id) {
        return null;
    }

    @Override
    public List<User> findUsersById(List<Integer> ids) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUserById(int id) {

    }

    @Override
    public User findUserAndMealsByIdJoinFetch(int id) {
        return null;
    }
}
