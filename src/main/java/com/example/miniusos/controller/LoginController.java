package com.example.miniusos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String home()
    {
<<<<<<< Updated upstream
        return ("/login/home.html");
=======
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().toString();
        if(auth.getAuthorities().toString().equals("[ROLE_ADMIN]"))
            return ("/login/admin_page.html");
        else if(auth.getAuthorities().toString().equals("[ROLE_STAFF]"))
            return ("/login/staff_page.html");
        else if(auth.getAuthorities().toString().equals("[ROLE_USER]"))
            return ("/login/student_page.html");
        else
            return  ("/login/home.html");

>>>>>>> Stashed changes
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

    // Login form with error
    @RequestMapping("/login_error")
    public String loginError() {
        return "login/login_error.html";
    }
}
