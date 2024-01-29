package com.callisto.demeter.service;

import com.callisto.demeter.entity.Food;
import com.callisto.demeter.entity.Meal;
import com.callisto.demeter.entity.User;

import java.util.List;

public interface MealAndFoodService {

    // Many/List Finds
    List<User> findAllUsers();
    User findUserWithMealsById(int userId);
    List<Meal> findOnlyMealsByUserId(int userId);
    Meal findMealWithFoodsById(int mealId);
    List<Food> findOnlyFoodsByMealId(int mealId);


    // Individual Finds
    Food findFoodById(int foodId);
    Meal findMealById(int mealId);
    User findUserById(int userId);


    // Update/Save Food To Meal
    void saveFoodToMeal(Food food, Meal meal);
    void saveFoodListToMeal(List<Food> foodList, Meal meal);
    void saveUser(User user);


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
