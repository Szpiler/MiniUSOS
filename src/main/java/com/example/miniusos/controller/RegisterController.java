package com.example.miniusos.controller;

import com.example.miniusos.model.PracownikNaukowy;
import com.example.miniusos.model.RegisterForm;
import com.example.miniusos.model.Uzytkownik;
import com.example.miniusos.repositories.UserRepository;
import com.example.miniusos.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.miniusos.model.User;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private UserRepository userRepository;

    // register form
    @RequestMapping("/register")
    public String register() {
        return "register/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute RegisterForm registerForm, BindingResult errors, Model model) {
        // tu może być jakaś walidacja danych etc

        if ( userRepository.findByUserName(registerForm.getEmail()).isPresent() )
        {
            return "register/register";
        }

        if (errors.hasErrors() ) {
            return "register/register";
        }


        registerService.register(registerForm);

        // tu podajesz do jakiego widoku chcesz przełączyć po zarejestrowaniu
        return "redirect:/";
    }
}
