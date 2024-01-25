package com.callisto.demeter;

import com.callisto.demeter.dao.FoodDAO;
import com.callisto.demeter.dao.MealDAO;
import com.callisto.demeter.dao.UserDAO;
import com.callisto.demeter.entity.Food;
import com.callisto.demeter.entity.Meal;
import com.callisto.demeter.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DemeterApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemeterApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(UserDAO userDAO, MealDAO mealDAO, FoodDAO foodDAO) {
//		return runner -> {
//			//crudUserMealFood(userDAO);
//
//			updateMealInUser(userDAO);
//		};
//	}

//	private void updateMealInUser(UserDAO userDAO) {
//		int id = 1;
//		Optional<User> resultUser = userDAO.findById(id);
//		User user = null;
//		if(resultUser.isPresent()) {
//			user = resultUser.get();
//			Meal meal = new Meal("Lunch-2", user);
//			user.add(meal);
//			userDAO.save(user);
//			System.out.println("Added Meal to User with Id = " + id);
//		} else {
//			System.out.println("Couldn't find User with Id = " + id);
//		}
//	}
//
//	private void crudUserMealFood(UserDAO userDAO) {
//		System.out.println("Creating a new user");
//		User tempUser = new User("jdoe","testPass","John","jdoe@gmail.com");
//		System.out.println("Creating a new meal");
//		Meal tempMeal = new Meal("TestLunch", tempUser);
//		tempUser.add(tempMeal);
//		System.out.println("Creating new foods to add to meal");
//		Food tempFood = new Food("Rice", "jdoe", 150, "g", 200);
//		Food tempFood2 = new Food("Ground Beef", "jdoe", 150, "oz", 6);
//		tempFood.setMeal(tempMeal);
//		tempFood2.setMeal(tempMeal);
//		tempMeal.add(tempFood);
//		tempMeal.add(tempFood2);
//		userDAO.save(tempUser);
//	}


}
