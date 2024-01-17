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

@SpringBootApplication
public class DemeterApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemeterApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserDAO userDAO, MealDAO mealDAO, FoodDAO foodDAO) {
		return runner -> {
			System.out.println("Hello World");
			crudUserMealFood(userDAO, mealDAO, foodDAO);
		};
	}

	private void crudUserMealFood(UserDAO userDAO, MealDAO mealDAO, FoodDAO foodDAO) {
		System.out.println("Creating a new user");
		User tempUser = new User("jdoe","testPass","John","jdoe@gmail.com");
		userDAO.saveUser(tempUser);
		System.out.println("Creating a new meal");
		Meal tempMeal = new Meal("TestLunch", "jdoe");
		int meal_id = mealDAO.saveMeal(tempMeal).getId();
		System.out.println("Creating new foods to add to meal");
		Food tempFood = new Food(meal_id, "Rice", "jdoe", 150, "g", 200);
		foodDAO.saveFood(tempFood);
		Food tempFood2 = new Food(meal_id, "Ground Beef", "jdoe", 150, "oz", 6);
		foodDAO.saveFood(tempFood2);
	}

	private void deleteMostRecent(UserDAO userDAO, MealDAO mealDAO, FoodDAO foodDAO) {
		System.out.println("Deleting Most Recent User and their Meals");

	}

	private void crudUser(UserDAO userDAO) {
		System.out.println("Creating a new user");
		User tempUser = new User("jdoe","testPass","John","jdoe@gmail.com");
		userDAO.saveUser(tempUser);
		List<User> users = userDAO.findAll();
		for(User user : users) {
			System.out.println(user);
		}
		int id = users.get(users.size()-1).getId();
		System.out.printf("User ID = %d", id);
		userDAO.deleteUserByID(id);
	}

	private void crudFood(FoodDAO foodDAO) {
		System.out.println("Creating a new food");
		Food tempFood = new Food(1, "Rice", "jdoe", 150, "g", 100);
		foodDAO.saveFood(tempFood);
		List<Food> foods = foodDAO.findAll();
		for(Food food : foods) {
			System.out.println(food);
		}
		int id = foods.get(foods.size()-1).getId();
		System.out.printf("User ID = %d", id);
		foodDAO.deleteFoodByID(id);
	}

	private void crudMeal(MealDAO mealDAO) {
		System.out.println("Creating a new meal");
		Meal tempMeal = new Meal();
		mealDAO.saveMeal(tempMeal);
		List<Meal> meals = mealDAO.findAll();
		for(Meal meal : meals) {
			System.out.println(meal);
		}
		int id = meals.get(meals.size()-1).getId();
		System.out.printf("User ID = %d", id);
		mealDAO.deleteMealByID(id);
	}

}
