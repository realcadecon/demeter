package com.callisto.demeter.controller;

import com.callisto.demeter.entity.Food;
import com.callisto.demeter.entity.Meal;
import com.callisto.demeter.service.MealAndFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/meals")
public class MealController {

    private MealAndFoodService mfService;

    @Autowired
    public MealController(MealAndFoodService mealAndFoodService) {
        mfService = mealAndFoodService;
    }

    @GetMapping("/list")
    public String showAllMeals(@RequestParam("id") int id, Model model) {
        List<Meal> mealList = mfService.findAllMealsForUser(id);
        if(mealList == null) {
            model.addAttribute("error", "Couldn't find any meals for this user...");
        } else {
            model.addAttribute("mealList", mealList);
        }
        return "meals/meal-list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("foodId") int foodId, @RequestParam("mealId") int mealId, Model model) {
        Meal meal = mfService.findMealById(mealId);
        Food foodToUpdate = null;
        if(meal != null) {
            foodToUpdate = mfService.findFoodById(foodId);
            model.addAttribute("updatedFood");
        }
        return "meals/food-update-form";
    }

    @PostMapping("/delete")
    public String deleteMeal(@ModelAttribute Meal mealToDelete) {
        int meal_id = mealToDelete.getId();
        int user_id = mfService.getAuthorOfMeal(meal_id);
        mfService.deleteMeal(meal_id);
        return "redirect:/meals/list?id="+user_id;
    }

}
