package com.callisto.demeter.controller;

import com.callisto.demeter.entity.Food;
import com.callisto.demeter.entity.Meal;
import com.callisto.demeter.service.UserMealFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/foods")
public class FoodController {

    private final UserMealFoodService umfService;

    @Autowired
    public FoodController(UserMealFoodService userMealFoodService) {
        umfService = userMealFoodService;
    }


    @PostMapping("/createFoodForm")
    public String showCreateFoodForm(@RequestParam int mealId, Model model) {
        model.addAttribute("mealId", mealId);
        model.addAttribute("food", new Food());
        return "foods/food-create-form";
    }

    @PostMapping("/create")
    public String createFood(@ModelAttribute Food food, @RequestParam int mealId, Model model) {
        Meal meal = umfService.findMealById(mealId);
        umfService.saveFoodToMeal(food, meal);
        model.addAttribute("meal", meal);
        model.addAttribute("userId", meal.getUser().getId());
        return "meals/meal-update-form";
    }

    @PostMapping("/updateFoodForm")
    public String showUpdateFoodForm(@RequestParam int foodId, Model model) {
        Food food = umfService.findFoodById(foodId);
        model.addAttribute("food", food);
        return "foods/food-update-form";
    }

    @PostMapping("/update")
    public String updateFood(@ModelAttribute Food food) {
        Meal meal = umfService.findFoodById(food.getId()).getMeal();
        food.setMeal(meal);
        umfService.saveFoodToMeal(food, meal);
        return "foods/food-update-form";
    }

    @PostMapping("/delete")
    public String deleteFood(@RequestParam int foodId, Model model) {
        Food toDelete = umfService.findFoodById(foodId);
        Meal meal = toDelete.getMeal();
        model.addAttribute("meal", meal);
        model.addAttribute("userId", meal.getUser().getId());
        umfService.deleteFood(toDelete);
        return "meals/meal-update-form";
    }

}
