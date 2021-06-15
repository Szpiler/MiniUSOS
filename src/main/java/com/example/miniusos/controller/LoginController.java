package com.example.miniusos.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String home()
    {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().toString();
        if(auth.getAuthorities().toString().equals("[ROLE_ADMIN]"))
            return ("/login/admin_page.html");
        else if(auth.getAuthorities().toString().equals("[ROLE_STAFF]"))
            return ("/login/staff_page.html");
        else if(auth.getAuthorities().toString().equals("[ROLE_USER]"))
            return ("/login/student_page.html");
        else
            return  ("/login/login.html");

    }

    @RequestMapping(value="/logout", method= RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
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
