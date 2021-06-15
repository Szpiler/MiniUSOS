package com.example.miniusos.controller;

import com.example.miniusos.repositories.OcenaRepository;
import com.example.miniusos.repositories.StudentRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PodgladWynikowController {
    private final StudentRepository studentRepository;
    private final OcenaRepository ocenaRepository;

    public PodgladWynikowController(StudentRepository studentRepository, OcenaRepository ocenaRepository) {
        this.studentRepository = studentRepository;
        this.ocenaRepository = ocenaRepository;
    }

    @RequestMapping("/wyniks")
    public String showResults(Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("wyniks", ocenaRepository.findById(studentRepository.findByName((String) auth.getPrincipal()).getId()));

        return "wyniks/list";
    }
}
