package com.callisto.demeter.service;

import com.callisto.demeter.entity.Food;
import com.callisto.demeter.entity.Meal;
import com.callisto.demeter.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserMealFoodService extends UserDetailsService {

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
    void saveMealToUser(Meal meal, User user);
    void saveMealListToUser(List<Meal> mealList, User user);


    // Delete Food(s)
    void deleteFood(Food food);
    void deleteFoods(List<Food> foodList);


    // Delete Meal(s)
    void deleteMeal(Meal meal);
    void deleteMeals(List<Meal> mealList);

    User findUserWithMealsByUsername(String currentUserName);
    User findUserByUsername(String currentUserName);
}
