package com.callisto.demeter.dao;

import com.callisto.demeter.entity.Food;
import com.callisto.demeter.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodDAO extends JpaRepository<Food, Integer> {

    @Query("select f FROM Food f where f.meal.id = ?1")
    List<Food> findFoodsByMealIdLazy(int mealId);

    @Query("select f FROM Food f where f.meal.id in (?1)")
    List<Food> findFoodsById(List<Integer> mealIDs);

}
