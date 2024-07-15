package com.callisto.demeter.controller.noauth;

import com.callisto.demeter.entity.Role;
import com.callisto.demeter.entity.User;
import com.callisto.demeter.service.UserMealFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LoginController {

    private UserMealFoodService umfService;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public LoginController(UserMealFoodService umfService, BCryptPasswordEncoder passwordEncoder) {
        this.umfService = umfService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String showLanding() {
        return "noauth/landing.html";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "noauth/register.html";
    }

    @PostMapping("/processRegistration")
    public String processRegistration(@ModelAttribute User user, Model model) {
        if(umfService.findUserByUsername(user.getUsername()) != null) {
            model.addAttribute("registrationStatus", "Username already taken.");
            return "redirect:/register";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role user_role = umfService.findRoleById(1);
        user.setRoles(List.of(user_role));

        umfService.saveUser(user);
        model.addAttribute("registrationStatus", "Successfully registered");
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "noauth/login.html";
    }
}
