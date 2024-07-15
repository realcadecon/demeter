package com.callisto.demeter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "email")
    private String email;

    @Column(name = "enabled")
    private int enabled;

    @OneToMany(mappedBy = "user",
            cascade = { CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Meal> meals;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    public User() {}

    public User(String username, String password, String firstName, String email, int enabled) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.email = email;
        this.enabled = enabled;
    }

    public User(String username, String password, String firstName, String email, int enabled, List<Meal> meals, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.email = email;
        this.enabled = enabled;
        this.meals = meals;
        this.roles = roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void add(Meal meal) {
        if(meals == null) {
            meals = new ArrayList<>();
        }
        meals.add(meal);
        meal.setUser(this);
    }

    public void add(List<Meal> mealList) {
        if(meals == null) {
            meals = new ArrayList<>();
        }
        mealList.forEach(m -> {
            m.setUser(this);
            meals.add(m);
        });
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
