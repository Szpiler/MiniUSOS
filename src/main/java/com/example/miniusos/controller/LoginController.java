package com.example.miniusos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String home()
    {
        return ("/login/home.html");
    }

    // Login form
    @RequestMapping("/login")
    public String login()
    {
        return "/login/login.html";
    }

    @RequestMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }

    @RequestMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }

//    // Login form with error
//    @RequestMapping("/login-error.html")
//    public String loginError(Model model) {
//        model.addAttribute("loginError", true);
//        return "login.html";
//    }
}
