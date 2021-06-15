package com.example.miniusos.controller;

import com.example.miniusos.model.Student;
import com.example.miniusos.repositories.OcenaRepository;
import com.example.miniusos.repositories.StudentRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

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
        List<Student> studenci = new ArrayList<>();
        studentRepository.findAll().forEach(studenci::add);
        long indeks = -1;
        for (Student s:studenci)
        {
            if(s.getLogin().equals(auth.getPrincipal()))
            {
                indeks = s.getId();
            }
        }
        model.addAttribute("wyniks", ocenaRepository.getById(indeks));
        auth.getPrincipal();
        return "wyniks/list";
    }
}