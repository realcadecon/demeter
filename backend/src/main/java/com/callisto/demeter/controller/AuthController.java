package com.callisto.demeter.controller;

import com.callisto.demeter.entity.AuthRequest;
import com.callisto.demeter.entity.Role;
import com.callisto.demeter.entity.User;
import com.callisto.demeter.service.JwtService;
import com.callisto.demeter.service.UserMealFoodService;
import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserMealFoodService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/test")
    public String testPost(@RequestBody Role role) {
        System.out.println("Role = " + role.getName());
        return "got post request";
    }

    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);

        List<Role> matchingRoles = new ArrayList<>();
        for(Role role : user.getRoles()) {
            Role res = service.findRoleByName(role.getName());
            if(res != null) {
                matchingRoles.add(res);
            }
        }
        user.setRoles(matchingRoles);

        return service.saveUser(user);
    }

    @GetMapping("/user/userProfile")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String userProfile() {
        return "Welcome to User Profile";
    }

    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }

    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) throws JoseException {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateJWTToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }

}
