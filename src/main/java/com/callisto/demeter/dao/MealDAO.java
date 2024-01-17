package com.callisto.demeter.dao;

import com.callisto.demeter.entity.Meal;
import com.callisto.demeter.entity.User;

import java.util.List;

public interface MealDAO {
    List<Meal> findAll();

    Meal findMealByID(int id);

    Meal saveMeal(Meal meal);

    void deleteMealByID(int id);
}
