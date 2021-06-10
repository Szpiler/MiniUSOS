package com.example.miniusos.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class LoginController {
    // Login form
    @RequestMapping("/login")
    public String login() {
        return "login/login_page";
    }

    // Login form with error
    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }
}
