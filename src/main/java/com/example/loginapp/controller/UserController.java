package com.example.loginapp.controller;

import com.example.loginapp.model.User;
import com.example.loginapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        service.registerUser(user);
        return "redirect:/login"; // redirect to login page after registration
    }
    @GetMapping("/loginpage")
    public String loginPage() {
        return "loginpage"; // maps to loginpage.html
    }
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        RedirectAttributes redirectAttributes) {

        boolean success = service.loginUser(username, password);

        if (success) {
            return "index"; 
        } else {
            redirectAttributes.addFlashAttribute("loginFailed", true);
            return "redirect:/loginpage";
        }
    }
}
