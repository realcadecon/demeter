package com.callisto.demeter.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "meal_id")
    private Meal meal;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "calories")
    private int calories;

    @Column(name = "serving_size")
    private String serving_size;

    @Column(name = "amount")
    private int amount;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getServing_size() {
        return serving_size;
    }

    public void setServing_size(String serving_size) {
        this.serving_size = serving_size;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public Food () {}

    public Food(Meal meal, String name, String author, int calories, String serving_size, int amount) {
        this.meal = meal;
        this.name = name;
        this.author = author;
        this.calories = calories;
        this.serving_size = serving_size;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", meal=" + meal +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", calories=" + calories +
                ", serving_size='" + serving_size + '\'' +
                ", amount=" + amount +
                '}';
    }
}
