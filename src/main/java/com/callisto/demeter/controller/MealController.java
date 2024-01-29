package com.callisto.demeter.controller;

import com.callisto.demeter.entity.Meal;
import com.callisto.demeter.entity.User;
import com.callisto.demeter.entity.Food;
import com.callisto.demeter.service.UserMealFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/meals")
public class MealController {

    private final UserMealFoodService umfService;

    @Autowired
    public MealController(UserMealFoodService userMealFoodService) {
        umfService = userMealFoodService;
    }

    @GetMapping
    public String showAllMeals(@RequestParam("id") int id, Model model) {
        User user = umfService.findUserWithMealsById(id);
        List<Meal> mealList = user.getMeals();
        System.out.println(user);
        model.addAttribute("User", user);
        if(mealList == null) {
            model.addAttribute("error", "Couldn't find any meals for this user...");
        } else {
            model.addAttribute("mealList", mealList);
        }
        return "meals/meal-list";
    }

    @PostMapping("/updateMealForm")
    public String showUpdateMealForm(@RequestParam("mealId") int mealId, Model model) {
        Meal meal = umfService.findMealWithFoodsById(mealId);
        model.addAttribute("meal", meal);
        return "meals/food-update-form";
    }

    @PostMapping("/update")
    public String updateMeal(@ModelAttribute Meal meal) {
        int uid = meal.getUser().getId();
        return "redirect:/meals?id="+uid;
    }

    @PostMapping("/createMealForm")
    public String showCreateMealForm(@RequestParam("mealId") int mealId, Model model) {
//        //Food food = umfService.findFoodById(foodId);
//        model.addAttribute("foodToUpdate", food);
        return "meals/food-create-form";
    }

    @PostMapping("/create")
    public String createMeal(@ModelAttribute Meal meal) {
        int uid = meal.getUser().getId();
        return "redirect:/meals?id="+uid;
    }

    @PostMapping("/delete")
    public String deleteMeal(@ModelAttribute Meal partialMeal) {
        Meal mealToDelete = umfService.findMealById(partialMeal.getId());
        int uid = mealToDelete.getUser().getId();
        umfService.deleteMeal(mealToDelete);
        return "redirect:/meals?id="+uid;
    }

}
