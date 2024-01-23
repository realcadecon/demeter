package com.callisto.demeter.dao;

import com.callisto.demeter.entity.Meal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MealDAOImpl implements MealDAO {

    private EntityManager entityManager;

    @Autowired
    public MealDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<Meal> findAll() {
        TypedQuery<Meal> query = entityManager.createQuery("SELECT FROM Meal", Meal.class);
        return query.getResultList();
    }

    @Override
    public Meal findMealByID(int id) {
        return entityManager.find(Meal.class, id);
    }

    @Override
    @Transactional
    public void saveMeal(Meal meal) {
        entityManager.persist(meal);
    }

    @Override
    @Transactional
    public void deleteMealByID(int id) {
        Meal mealToRemove = entityManager.find(Meal.class, id);
        entityManager.remove(mealToRemove);
    }
}
