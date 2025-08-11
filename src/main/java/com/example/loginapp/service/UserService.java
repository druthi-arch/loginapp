package com.example.loginapp.service;

import com.example.loginapp.model.User;
import com.example.loginapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;  // make sure name is userRepository

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return true;
        }
        return false;
    }

    public String registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return "Username already exists!";
        }

        // Encrypt the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
        return "Registration successful!";
    }
}
