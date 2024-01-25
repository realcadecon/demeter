package com.callisto.demeter.dao;

import com.callisto.demeter.entity.Food;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FoodDAOImpl implements FoodDAO {

    private EntityManager entityManager;

    @Autowired
    public FoodDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveFood(Food food) {
        entityManager.persist(food);
    }

    @Override
    public void saveFoods(List<Food> foods) {
        for(Food food : foods) {
            entityManager.persist(food);
        }
    }

    @Override
    public Food findFoodById(int id) {
        TypedQuery<Food> foodQuery = entityManager.createQuery("select FROM Food where Food.id = :data", Food.class);
        foodQuery.setParameter("data", id);
        return foodQuery.getSingleResult();
    }

    @Override
    public List<Food> findFoodsById(List<Integer> ids) {
        TypedQuery<Food> foodQuery = entityManager.createQuery("select * FROM Food where Food.id in (:data)", Food.class);
        String idList = ids.stream().map(String::valueOf).collect(Collectors.joining(","));
        foodQuery.setParameter("data", idList);
        return foodQuery.getResultList();
    }

    @Override
    public void updateFood(Food food) {
        entityManager.merge(food);
    }

    @Override
    public void deleteFoodById(int id) {
        Food foodToDelete = entityManager.find(Food.class, id);
        entityManager.remove(foodToDelete);
    }
}
