package com.example.miniusos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
    // register form
    @RequestMapping("/register")
    public String register() {
        return "register/register";
    }
}
