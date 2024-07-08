package com.callisto.demeter.security;

import com.callisto.demeter.filter.JwtAuthFilter;
import com.callisto.demeter.service.JwtService;
import com.callisto.demeter.service.UserMealFoodService;
import com.callisto.demeter.service.UserMealFoodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthFilter jwtFilter;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserMealFoodServiceImpl();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers("/generic").permitAll()
                                .requestMatchers("/auth/welcome", "/auth/addNewUser", "/auth/generateToken").permitAll()
                                .anyRequest().authenticated())
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

//                .authorizeHttpRequests(configurer ->
//                        configurer
//                                .requestMatchers("/").permitAll()
//                                .requestMatchers("/register").permitAll()
//                                .requestMatchers("/processRegistration").permitAll()
//                                .requestMatchers("/css/**").permitAll()
//                                .requestMatchers("/api/**").permitAll()
//                                .anyRequest().authenticated()
//                )
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
//                )
//                .formLogin(form ->
//                        form
//                                .loginPage("/login")
//                                .loginProcessingUrl("/authenticate")
//                                .permitAll()
//                                .defaultSuccessUrl("/meals", true)
//                )
//                .logout(logout -> logout.permitAll()
//                );

        return http.build();
    }

    private AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuth = new DaoAuthenticationProvider();
        daoAuth.setUserDetailsService(userDetailsService());
        daoAuth.setPasswordEncoder(passwordEncoder());
        return daoAuth;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider(UserMealFoodService umfService) {
//        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//        auth.setUserDetailsService(umfService);
//        auth.setPasswordEncoder(passwordEncoder());
//        return auth;
//    }
}
