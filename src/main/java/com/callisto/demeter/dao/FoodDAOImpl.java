package com.callisto.demeter.dao;

import com.callisto.demeter.entity.Food;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FoodDAOImpl implements FoodDAO {

    private EntityManager entityManager;

    @Autowired
    public FoodDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<Food> findAll() {
        TypedQuery<Food> findFood = entityManager.createQuery("FROM Food", Food.class);
        return findFood.getResultList();
    }

    @Override
    public Food findFoodByID(int id) {
        return entityManager.find(Food.class, id);
    }

    @Override
    @Transactional
    public void saveFood(Food food) {
        entityManager.persist(food);
    }

    @Override
    @Transactional
    public void deleteFoodByID(int id) {
        Food foodToRemove = entityManager.find(Food.class, id);
        entityManager.remove(foodToRemove);

    }
}
