package com.callisto.demeter.dao;

import com.callisto.demeter.entity.Food;
import com.callisto.demeter.entity.Meal;
import com.callisto.demeter.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealDAO {

    //Basic CRUD
    void saveMeal(Meal meal);
    void saveMeals(List<Meal> meals);
    Meal findMealById(int id);
    List<Meal> findMealsById(List<Integer> ids);
    void updateMeal(Meal meal);
    void deleteMealById(int id);

}
