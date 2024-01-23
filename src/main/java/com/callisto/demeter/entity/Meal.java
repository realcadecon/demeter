package com.callisto.demeter.entity;

import jakarta.persistence.*;

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

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "meal")
    private List<Food> foods;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Meal(String name) {
        this.name = name;
    }

    public Meal(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public Meal(String name, User user, List<Food> foods) {
        this.name = name;
        this.user = user;
        this.foods = foods;
    }

    public void add(Food food) {
        foods.add(food);
        food.setMeal(this);
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", foods=" + foods +
                '}';
    }
}
