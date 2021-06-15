package com.example.miniusos.controller;

import com.example.miniusos.model.Przedmiot;
import com.example.miniusos.model.PrzedmiotForm;
import com.example.miniusos.repositories.PracownikNaukowyRepository;
import com.example.miniusos.service.PrzedmiotService;
import com.example.miniusos.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PracownikNaukowyController {
    private final PracownikNaukowyRepository pracownikNaukowyRepository;

    @Autowired
    private PrzedmiotService przedmiotService;

    public PracownikNaukowyController(PracownikNaukowyRepository pracownikNaukowyRepository) {this.pracownikNaukowyRepository = pracownikNaukowyRepository;}

    @RequestMapping("/add")
    public String setPracownikNaukowy()
    {
        //model.addAttribute("science_workers", pracownikNaukowyRepository.findAll());

        return "add/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String setPracownikNaukowy(@ModelAttribute PrzedmiotForm przedmiot, BindingResult errors, Model model) {

        if (errors.hasErrors()) {
            // tu podajesz do jakiego widoku chcesz przełączyć przy błędzie (błędy typu niepoprawne dane w formularzu)
            return "/przedmiots";
        }

        przedmiotService.add(przedmiot);

        // tu podajesz do jakiego widoku chcesz przełączyć po zarejestrowaniu
        return "redirect:/add";
    }
}
