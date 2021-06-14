package com.example.miniusos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    // Login form
    @RequestMapping("/login")
    public String login() {
=======


    // Login form
    @RequestMapping("/")
    public String login()
    {
<<<<<<< HEAD
>>>>>>> parent of e837290 (Working logging)
=======
    // Login form
    @RequestMapping("/login")
    public String login() {
>>>>>>> parent of 03b37ea (Added Login Service)
=======
    // Login form
    @RequestMapping("/login")
    public String login() {
>>>>>>> parent of 03b37ea (Added Login Service)
=======
>>>>>>> parent of e837290 (Working logging)
        return "login/login_page";
    }

//    // Login form with error
//    @RequestMapping("/login-error.html")
//    public String loginError(Model model) {
//        model.addAttribute("loginError", true);
//        return "login.html";
//    }
}
