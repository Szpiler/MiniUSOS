package com.example.miniusos.controller;

import com.example.miniusos.model.PracownikNaukowy;
import com.example.miniusos.repositories.PracownikNaukowyRepository;
import com.example.miniusos.repositories.PrzedmiotRepository;
import com.example.miniusos.service.PracwonikNaukowyService;
import com.example.miniusos.service.PrzedmiotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrzedmiotAllController {
    private final PrzedmiotRepository przedmiotRepository;

    public PrzedmiotAllController(PrzedmiotRepository przedmiotRepository) {this.przedmiotRepository = przedmiotRepository;}

    @RequestMapping("/przedmiotsAll")
    public String getPrzedmiotsAll(Model model)
    {
        model.addAttribute("przedmiots", przedmiotRepository.findAll());
        return "dziekanat/przedmiots/list";
    }

}
