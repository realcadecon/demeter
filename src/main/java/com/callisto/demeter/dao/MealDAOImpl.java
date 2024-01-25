package com.callisto.demeter.dao;

import com.callisto.demeter.entity.Meal;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MealDAOImpl implements MealDAO {
    @Override
    public void saveMeal(Meal meal) {

    }

    @Override
    public void saveMeals(List<Meal> meals) {

    }

    @Override
    public Meal findMealById(int id) {
        return null;
    }

    @Override
    public List<Meal> findMealsById(List<Integer> ids) {
        return null;
    }

    @Override
    public void updateMeal(Meal meal) {

    }

    @Override
    public void deleteMealById(int id) {

    }
}
