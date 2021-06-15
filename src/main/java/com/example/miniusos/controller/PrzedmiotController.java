package com.example.miniusos.controller;

import com.example.miniusos.repositories.PrzedmiotRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrzedmiotController {
    private final PrzedmiotRepository przedmiotRepository;

    public PrzedmiotController(PrzedmiotRepository przedmiotRepository) {this.przedmiotRepository = przedmiotRepository;}

    @RequestMapping("/przedmiots")
    public String getPrzedmiots(Model model)
    {
        model.addAttribute("przedmiots", przedmiotRepository.findAll());

        return "student/przedmiots/list";
    }
}
