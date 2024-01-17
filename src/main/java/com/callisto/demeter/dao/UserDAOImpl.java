package com.callisto.demeter.dao;

import com.callisto.demeter.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {

    private EntityManager entityManager;

    //Injecting Entity Manager
    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> findUsers = entityManager.createQuery("FROM User", User.class);
        return findUsers.getResultList();
    }

    @Override
    public User findUserByID(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void deleteUserByID(int id) {
        User userToDelete = entityManager.find(User.class, id);
        entityManager.remove(userToDelete);
    }
}
