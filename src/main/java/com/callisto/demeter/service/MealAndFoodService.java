package com.callisto.demeter.service;

import com.callisto.demeter.entity.Food;
import com.callisto.demeter.entity.Meal;
import com.callisto.demeter.entity.User;

import java.util.List;

public interface MealAndFoodService {

    // Table Display Operations
    List<Meal> findAllMealsForUserIdLazy(int id);
    List<Food> findAllFoodsForMealIdLazy(int id);


    // Meal Detail Display Operations
    Meal findMealAndFoodsByIdJoinFetch(int id);


    //User and Meal Detail Display Operations
    User findUserAndMealsByIdJoinFetch(int id);


    // Food Detail Display Operations
    Food findFoodById(int id);


    // Update/Save Food To Meal
    void saveFoodToMeal(Food food, Meal meal);
    void saveFoodListToMeal(List<Food> foodList, Meal meal);


    // Update/Save Meal and Foods To User
    void saveMealToUser(Meal meal, int userId);
    void saveMealListToUser(List<Meal> mealList, int userId);


    // Delete Food(s)
    void deleteFood(int id);
    void deleteFoods(List<Integer> foodIds);


    // Delete Meal(s)
    void deleteMeal(int mealId);
    void deleteMeals(List<Integer> mealIds);

}
