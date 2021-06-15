package com.example.miniusos.controller;

import com.example.miniusos.model.Ocena;
import com.example.miniusos.model.Student;
import com.example.miniusos.repositories.OcenaRepository;
import com.example.miniusos.repositories.StudentRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
        Optional<Student> student = studentRepository.findByLogin(auth.getPrincipal().toString());
        student.orElseThrow(() -> new UsernameNotFoundException("Nie znaleziono: "));
        Set<Ocena> oceny = student.get().getOceny();
        for(Iterator<Ocena> it = oceny.iterator(); it.hasNext();)
        {
            Ocena o = it.next();
            indeks = o.getId();
        }
        model.addAttribute("wyniks", ocenaRepository.getById(indeks));
        auth.getPrincipal();
        return "wyniks/list";
    }
}