package com.callisto.demeter.service;

import com.callisto.demeter.dao.FoodDAO;
import com.callisto.demeter.dao.MealDAO;
import com.callisto.demeter.dao.UserDAO;
import com.callisto.demeter.entity.Food;
import com.callisto.demeter.entity.Meal;
import com.callisto.demeter.entity.User;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealAndFoodServiceImpl implements MealAndFoodService {

    private FoodDAO foodDAO;
    private MealDAO mealDAO;
    private UserDAO userDAO;


    @Autowired
    public MealAndFoodServiceImpl(FoodDAO foodDAO, MealDAO mealDAO, UserDAO userDAO) {
        this.foodDAO = foodDAO;
        this.mealDAO = mealDAO;
        this.userDAO = userDAO;
    }

    @Override
    public List<Meal> findAllMealsForUserIdLazy(int id) {
        return null;
    }

    @Override
    public List<Food> findAllFoodsForMealIdLazy(int id) {
        return null;
    }

    @Override
    public Meal findMealAndFoodsByIdJoinFetch(int id) {
        return null;
    }

    @Override
    public User findUserAndMealsByIdJoinFetch(int id) {
        return null;
    }

    @Override
    public Food findFoodById(int id) {
        return null;
    }

    @Override
    public void saveFoodToMeal(Food food, Meal meal) {

    }

    @Override
    public void saveFoodListToMeal(List<Food> foodList, Meal meal) {

    }

    @Override
    public void saveMealToUser(Meal meal, int userId) {

    }

    @Override
    public void saveMealListToUser(List<Meal> mealList, int userId) {

    }

    @Override
    public void deleteFood(int id) {

    }

    @Override
    public void deleteFoods(List<Integer> foodIds) {

    }

    @Override
    public void deleteMeal(int mealId) {

    }

    @Override
    public void deleteMeals(List<Integer> mealIds) {

    }


//    @Override
//    public List<Meal> findAllMealsForUser(int id) {
//        Optional<User> userResult = userDAO.findById(id);
//        List<Meal> mealList = null;
//        if(userResult.isPresent()) {
//            mealList = userResult.get().getMeals();
//        }
//        return mealList;
//    }
//
//    @Override
//    public Meal findMealById(int id) {
//        Optional<Meal> mealResult = mealDAO.findById(id);
//        Meal meal = null;
//        if(mealResult.isPresent()) {
//            meal = mealResult.get();
//        }
//        return meal;
//    }
//
//    @Override
//    public Food findFoodById(int id) {
//        Optional<Food> foodResult = foodDAO.findById(id);
//        Food food = null;
//        if(foodResult.isPresent()) {
//            food = foodResult.get();
//        }
//        return food;
//    }
//
//    @Override
//    public Food findAllFoodByMealId(int id) {
//        return null;
//    }
//
//    @Override
//    public void saveFoodToMeal(Food food, Meal meal) {
//        meal.add(food);
//        food.setMeal(meal);
//        mealDAO.save(meal);
//    }
//
//    @Override
//    public void saveFoodListToMeal(List<Food> foodList, Meal meal) {
//        for(Food food : foodList) {
//            meal.add(food);
//            food.setMeal(meal);
//        }
//        mealDAO.save(meal);
//    }
//
//    @Override
//    public void saveMealToUser(Meal meal, int userId) {
//        Optional<User> resultUser = userDAO.findById(userId);
//        User user = null;
//        if(resultUser.isPresent()) {
//            user = resultUser.get();
//            user.add(meal);
//            meal.setUser(user);
//        }
//        userDAO.save(user);
//    }
//
//    @Override
//    public void saveMealListToUser(List<Meal> mealList, User user) {
//
//    }
//
//    @Override
//    public void deleteMeal(int mealId) {
//        mealDAO.deleteById(mealId);
//    }

}
