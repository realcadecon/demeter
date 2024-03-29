package com.callisto.demeter.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "calories")
    private int calories;

    @Column(name = "protein")
    private int protein;

    @Column(name = "carbs")
    private int carbs;

    @Column(name = "fat")
    private int fat;

    @Column(name = "calories-goal")
    private int caloriesGoal;

    @Column(name = "protein-goal")
    private int proteinGoal;

    @Column(name = "carbs-goal")
    private int carbsGoal;

    @Column(name = "fat-goal")
    private int fatGoal;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
                        CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "meal",
            cascade = CascadeType.ALL)
    private List<Food> foods;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getCarbs() {
        return carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getCaloriesGoal() {
        return caloriesGoal;
    }

    public void setCaloriesGoal(int caloriesGoal) {
        this.caloriesGoal = caloriesGoal;
    }

    public int getProteinGoal() {
        return proteinGoal;
    }

    public void setProteinGoal(int proteinGoal) {
        this.proteinGoal = proteinGoal;
    }

    public int getCarbsGoal() {
        return carbsGoal;
    }

    public void setCarbsGoal(int carbsGoal) {
        this.carbsGoal = carbsGoal;
    }

    public int getFatGoal() {
        return fatGoal;
    }

    public void setFatGoal(int fatGoal) {
        this.fatGoal = fatGoal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public Meal() {}

    public Meal(String name, int calories, int protein, int carbs, int fat, int caloriesGoal, int proteinGoal, int carbsGoal, int fatGoal) {
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
        this.caloriesGoal = caloriesGoal;
        this.proteinGoal = proteinGoal;
        this.carbsGoal = carbsGoal;
        this.fatGoal = fatGoal;
    }

    public void add(Food food) {
        if(foods == null) {
            foods = new ArrayList<>();
        }
        foods.add(food);
        food.setMeal(this);

        this.calories += food.getCalories();
        this.protein += food.getProtein();
        this.carbs += food.getCarbs();
        this.fat += food.getFat();
    }

    public void removeFoodFromSummary(Food food) {
        this.calories -= food.getCalories();
        this.protein -= food.getProtein();
        this.carbs -= food.getCarbs();
        this.fat -= food.getFat();
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                '}';
    }
}
