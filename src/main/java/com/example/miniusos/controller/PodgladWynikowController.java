package com.example.miniusos.controller;

import com.example.miniusos.model.Ocena;
import com.example.miniusos.model.Student;
import com.example.miniusos.repositories.OcenaRepository;
import com.example.miniusos.repositories.StudentRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

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
        Long indeks = -1L;
        String username = auth.getName();
        List<Student> studenci = new ArrayList<>();
        studentRepository.findAll().forEach(studenci::add);
        for (Student s:studenci)
        {
            String pom = s.getLogin();
            if(pom.equals(username))
            {
                indeks = s.getId();
            }
        }
        List<Ocena> oceny = new ArrayList<>();
        List<Ocena> ocenki = new ArrayList<>();
        ocenaRepository.findAll().forEach(ocenki::add);
        for (Ocena o:ocenki)
        {
            Long pom = o.getStudent().getId();
            if(pom == indeks)
            {
                oceny.add(o);
            }
        }
        model.addAttribute("wyniks", oceny);
        return "wyniks/list";
    }
}