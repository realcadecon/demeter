package com.callisto.demeter.service;

import com.callisto.demeter.dao.FoodDAO;
import com.callisto.demeter.dao.MealDAO;
import com.callisto.demeter.dao.UserDAO;
import com.callisto.demeter.entity.Food;
import com.callisto.demeter.entity.Meal;
import com.callisto.demeter.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserMealFoodServiceImpl implements UserMealFoodService {

    private FoodDAO foodDAO;
    private MealDAO mealDAO;
    private UserDAO userDAO;


    @Autowired
    public UserMealFoodServiceImpl(FoodDAO foodDAO, MealDAO mealDAO, UserDAO userDAO) {
        this.foodDAO = foodDAO;
        this.mealDAO = mealDAO;
        this.userDAO = userDAO;
    }

    @Override
    public List<User> findAllUsers() {
        return userDAO.findAll();
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
        return mealDAO.findMealWithFoods(mealId);
    }

    @Override
    @Transactional
    public List<Food> findOnlyFoodsByMealId(int mealId) {
        return foodDAO.findFoodsByMealIdLazy(mealId);
    }

    @Override
    public Food findFoodById(int id) {
        Optional<Food> foodResult = foodDAO.findById(id);
        Food food = null;
        if(foodResult.isPresent()) {
            food = foodResult.get();
        }
        return food;
    }

    @Override
    public Meal findMealById(int mealId) {
        Optional<Meal> mealResult = mealDAO.findById(mealId);
        if(mealResult.isPresent()) {
            return mealResult.get();
        }
        return null;
    }

    @Override
    public User findUserById(int userId)  {
        Optional<User> userResult = userDAO.findById(userId);
        if(userResult.isPresent()) {
            return userResult.get();
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void saveFoodToMeal(Food food, Meal meal) {
       meal.add(food);
       mealDAO.save(meal);
    }

    @Override
    @Transactional
    public void saveFoodListToMeal(List<Food> foodList, Meal meal) {
        foodList.forEach(meal::add);
        mealDAO.save(meal);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.save(user);
    }

    @Override
    @Transactional
    public void saveMealToUser(Meal meal, User user) {
        user.add(meal);
        userDAO.save(user);
    }

    @Override
    @Transactional
    public void saveMealListToUser(List<Meal> mealList, User user) {
        mealList.forEach(user::add);
        userDAO.save(user);
    }


    @Override
    @Transactional
    public void deleteFood(Food food) {
        Meal meal = food.getMeal();
        meal.removeFoodFromSummary(food);
        foodDAO.delete(food);
    }

    @Override
    @Transactional
    public void deleteFoods(List<Food> foodList) {
        foodList.forEach(foodDAO::delete);
    }

    @Override
    @Transactional
    public void deleteMeal(Meal meal) {
        mealDAO.delete(meal);
    }

    @Override
    @Transactional
    public void deleteMeals(List<Meal> mealList) {
        mealList.forEach(mealDAO::delete);
    }
}
