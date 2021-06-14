package com.example.miniusos.controller;

import com.example.miniusos.model.RegisterForm;
import com.example.miniusos.model.DolaczDoPrzedmiotForm;
import com.example.miniusos.repositories.PrzedmiotRepository;
import com.example.miniusos.service.DolaczDoPrzedmiotService;
import com.example.miniusos.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class DolaczDoPrzedmiotController {

    @Autowired
    private DolaczDoPrzedmiotService dolaczDoPrzedmiotService;

    // register form
    @RequestMapping("/list")
    public String dolaczDoPrzedmiot() {
        return "list/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public String dolaczDoPrzedmiot(@ModelAttribute DolaczDoPrzedmiotForm dolaczDoPrzedmiotForm, BindingResult errors, Model model) {

        if (errors.hasErrors()) {
            // tu podajesz do jakiego widoku chcesz przełączyć przy błędzie (błędy typu niepoprawne dane w formularzu)
            return "register/register";
        }

        dolaczDoPrzedmiotService.dolaczDoPrzedmiot(dolaczDoPrzedmiotForm);

        // tu podajesz do jakiego widoku chcesz przełączyć po zarejestrowaniu
        return "redirect:/list";
    }
}