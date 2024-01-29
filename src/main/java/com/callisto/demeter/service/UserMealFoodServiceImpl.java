package com.callisto.demeter.service;

import com.callisto.demeter.dao.FoodDAO;
import com.callisto.demeter.dao.MealDAO;
import com.callisto.demeter.dao.UserDAO;
import com.callisto.demeter.entity.Food;
import com.callisto.demeter.entity.Meal;
import com.callisto.demeter.entity.User;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
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
    public List<User> findAllUsers() {
        return null;
    }

    @Override
    public User findUserWithMealsById(int id) {
        return userDAO.findUserAndMealsByIdJoinFetch(id);
    }

    public List<Meal> findOnlyMealsByUserId(int id) {
        return mealDAO.findMealsByUserIdLazy(id);
    }

    @Override
    public Meal findMealWithFoodsById(int mealId) {
        return mealDAO.findMealAndFoodsByIdJoinFetch(mealId);
    }

    @Override
    public List<Food> findOnlyFoodsByMealId(int mealId) {
        return null;
    }

    @Override
    public Food findFoodById(int id) {
        return null;
    }

    @Override
    public Meal findMealById(int mealId) {
        return null;
    }

    @Override
    public User findUserById(int userId) {
        return null;
    }

    @Override
    @Transactional
    public void saveFoodToMeal(Food food, Meal meal) {

    }

    @Override
    @Transactional
    public void saveFoodListToMeal(List<Food> foodList, Meal meal) {

    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public void saveMealToUser(Meal meal, int userId) {

    }

    @Override
    @Transactional
    public void saveMealListToUser(List<Meal> mealList, int userId) {

    }



    @Override
    @Transactional
    public void deleteFood(int id) {

    }

    @Override
    @Transactional
    public void deleteFoods(List<Integer> foodIds) {

    }

    @Override
    @Transactional
    public void deleteMeal(int mealId) {

    }

    @Override
    @Transactional
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
