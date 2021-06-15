package com.example.miniusos.controller;

import com.example.miniusos.repositories.PracownikNaukowyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PracownikNaukowyController {
    private final PracownikNaukowyRepository pracownikNaukowyRepository;

    public PracownikNaukowyController(PracownikNaukowyRepository pracownikNaukowyRepository) {this.pracownikNaukowyRepository = pracownikNaukowyRepository;}

    @RequestMapping("/adder")
    public String getPracownikNaukowy(Model model)
    {
        model.addAttribute("science_workers", pracownikNaukowyRepository.findAll());

        return "dziekanat/adder/add";
    }
}
