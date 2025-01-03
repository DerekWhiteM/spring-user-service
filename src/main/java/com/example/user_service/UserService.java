package com.example.user_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDetailsManager userDetailsManager;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public void registerNewUser(User user) {
        if (userDetailsManager.userExists(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        
        UserDetails userDetails = org.springframework.security.core.userdetails.User
            .withUsername(user.getUsername())
            .password(passwordEncoder.encode(user.getPassword()))
            .roles("USER")
            .build();
            
        userDetailsManager.createUser(userDetails);
    }
}
