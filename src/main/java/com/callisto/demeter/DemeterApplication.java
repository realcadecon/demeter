package com.callisto.demeter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@Profile("!test")
@SpringBootApplication
public class DemeterApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemeterApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(UserMealFoodService umfService) {
//		return runner -> {
//		};
//	}

//	private void updateMeal(UserMealFoodService umfService) {
//		int id = 1;
//		User user = umfService.findUserById(1);
//
//	}
//
//	private void findOnlyFoods(UserMealFoodService umfService) {
//		List<Food> foodList = umfService.findOnlyFoodsByMealId(9);
//		foodList.forEach(food -> {
//			System.out.println("Name = " + food.getName()
//					+ "\nCalories = " + food.getCalories()
//					+ "\nId = " + food.getId());
//		});
//	}
//
//	private void findBothMealAndFoods(UserMealFoodService umfService) {
//		Meal meal = umfService.findMealWithFoodsById(1);
//		List<Food> foodList = meal.getFoods();
//		System.out.print(meal);
//		foodList.forEach(System.out::println);
//	}
//
//
//	private void findJustUser(UserMealFoodService umfService) {
//		int id = 1;
//		System.out.println("Looking for User with ID = " + id);
//		try {
//			User user = umfService.findUserById(id);
//			System.out.println("Found User :: " + user);
//
//		} catch (Exception e) {
//			System.out.println("Exception Thrown: could not find user with ID = " + id);
//		}
//	}
//	private void findJustFood(UserMealFoodService umfService) {
//		int id = 1;
//		System.out.println("Looking for User with ID = " + id);
//		try {
//			User user = umfService.findUserById(id);
//			System.out.println("Found User :: " + user);
//
//		} catch (Exception e) {
//			System.out.println("Exception Thrown: could not find user with ID = " + id);
//		}
//	}
//
//	private void crudUserMealFood(UserMealFoodService umfService) {
//		System.out.println("Creating a new user");
//		User tempUser = new User("sydRut","sydRut","Sydney","srut@gmail.com", 1);
//		System.out.println("Creating a new meal");
//		Meal tempMeal = new Meal("Test-Breakfast", 0, 0, 0, 0);
//		tempUser.add(tempMeal);
//		System.out.println("Creating new foods to add to meal");
//		Food tempFood = new Food("Eggs", 100, 20, 0, 10, "g", 50);
//		Food tempFood2 = new Food("Ground Beef", 100 , 30, 5, 8, "oz", 4);
//		Food tempFood3 = new Food("Banana", 85, 1, 30, 0, "1 banana", 1);
//		tempFood.setMeal(tempMeal);
//		tempFood2.setMeal(tempMeal);
//		tempFood3.setMeal(tempMeal);
//		tempMeal.add(tempFood);
//		tempMeal.add(tempFood2);
//		tempMeal.add(tempFood3);
//		umfService.saveUser(tempUser);
//	}


}
