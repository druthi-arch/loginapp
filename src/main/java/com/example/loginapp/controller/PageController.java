package com.example.loginapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "loginpage"; 
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "registrationpage"; 
    }
}
