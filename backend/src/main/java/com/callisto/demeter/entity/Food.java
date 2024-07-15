package com.callisto.demeter.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "food")
public class Food {

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

    @Column(name = "serving_size")
    private String serving_size;

    @Column(name = "amount")
    private float amount;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "meal_id")
    private Meal meal;

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

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

    public String getServing_size() {
        return serving_size;
    }

    public void setServing_size(String serving_size) {
        this.serving_size = serving_size;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Food () {}

    public Food(String name, int calories, int protein, int carbs, int fat, String serving_size, int amount) {
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
        this.serving_size = serving_size;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", proteins=" + protein +
                ", carbs=" + carbs +
                ", fats=" + fat +
                ", serving_size='" + serving_size + '\'' +
                ", amount=" + amount +
                '}';
    }
}
