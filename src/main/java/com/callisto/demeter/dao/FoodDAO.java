package com.callisto.demeter.dao;

import com.callisto.demeter.entity.Food;
import com.callisto.demeter.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodDAO {

    //Basic CRUD
    void saveFood(Food food);
    void saveFoods(List<Food> foods);
    Food findFoodById(int id);
    List<Food> findFoodsById(List<Integer> ids);
    void updateFood(Food user);
    void deleteFoodById(int id);

}
