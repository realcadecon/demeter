package com.callisto.demeter.dao;

import com.callisto.demeter.entity.Food;

import java.util.List;

public interface FoodDAO {

    List<Food> findAll();

    Food findFoodByID(int id);

    void saveFood(Food food);

    void deleteFoodByID(int id);
}
