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
        if(user == null) {
            user = umfService.findUserById(id);
        }
        List<Meal> mealList = user.getMeals();
        model.addAttribute("user", user);
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
        if(meal == null) {
            meal = umfService.findMealById(mealId);
        }
        model.addAttribute("meal", meal);
        model.addAttribute("userId", meal.getUser().getId());
        return "meals/meal-update-form";
    }

    @PostMapping("/update")
    public String updateMeal(@ModelAttribute Meal meal) {
        if(meal.getFoods() != null) {
            meal.getFoods().forEach(food -> food.setMeal(meal));
        }
        User user = meal.getUser();
        umfService.saveMealToUser(meal, user);
        return "redirect:/meals?id=" + user.getId();
    }

    @PostMapping("/createMealForm")
    public String showCreateMealForm(@RequestParam("userId") int userId, Model model) {
        User user = umfService.findUserById(userId);
        model.addAttribute("user", user);
        model.addAttribute("meal", new Meal());
        return "meals/meal-create-form";
    }

    @PostMapping("/create")
    public String createMeal(@ModelAttribute Meal meal, @RequestParam("userId") int userId) {
        User user = umfService.findUserById(userId);
        umfService.saveMealToUser(meal, user);
        return "redirect:/meals?id="+userId;
    }

    @PostMapping("/delete")
    public String deleteMeal(@ModelAttribute Meal partialMeal) {
        Meal mealToDelete = umfService.findMealById(partialMeal.getId());
        int uid = mealToDelete.getUser().getId();
        umfService.deleteMeal(mealToDelete);
        return "redirect:/meals?id="+uid;
    }

}
