package com.callisto.demeter.dao;

import com.callisto.demeter.entity.Food;
import com.callisto.demeter.entity.Meal;
import com.callisto.demeter.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MealDAO extends JpaRepository<Meal, Integer> {
    @Query("SELECT m FROM Meal m JOIN FETCH m.foods WHERE m.id = ?1") Meal findMealWithFoods(int mealID);

    @Query("SELECT m FROM Meal m WHERE m.user.id = ?1") List<Meal> findMealsByUserIdLazy(int id);

}
