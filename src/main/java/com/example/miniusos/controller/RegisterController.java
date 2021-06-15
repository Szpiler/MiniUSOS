package com.example.miniusos.controller;

import com.example.miniusos.model.RegisterForm;
import com.example.miniusos.model.Uzytkownik;
import com.example.miniusos.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    // register form
    @RequestMapping("/register")
    public String register() {
        return "register/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute RegisterForm registerForm, BindingResult errors, Model model) {
        // tu może być jakaś walidacja danych etc

        if (errors.hasErrors()) {
            // tu podajesz do jakiego widoku chcesz przełączyć przy błędzie (błędy typu niepoprawne dane w formularzu)
            return "register/register";
        }

        registerService.register(registerForm);

        // tu podajesz do jakiego widoku chcesz przełączyć po zarejestrowaniu
        return "redirect:/";
    }
}
