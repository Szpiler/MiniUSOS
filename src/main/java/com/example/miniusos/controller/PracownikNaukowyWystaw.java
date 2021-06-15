package com.example.miniusos.controller;

import com.example.miniusos.model.PracownikNaukowy;
import com.example.miniusos.model.Przedmiot;
import com.example.miniusos.repositories.PracownikNaukowyRepository;
import com.example.miniusos.repositories.PrzedmiotRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PracownikNaukowyWystaw {
    private final PracownikNaukowyRepository pracownikNaukowyRepository;
    private final PrzedmiotRepository przedmiotRepository;

    public PracownikNaukowyWystaw(PracownikNaukowyRepository pracownikNaukowyRepository, PrzedmiotRepository przedmiotRepository) {
        this.pracownikNaukowyRepository = pracownikNaukowyRepository;
        this.przedmiotRepository = przedmiotRepository;
    }

    @RequestMapping("/wystaw")
    public String listPrzedmiotow(Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Long indeks = -1L;
        String username = auth.getName();
        List<PracownikNaukowy> nauczyciele = new ArrayList<>();
        pracownikNaukowyRepository.findAll().forEach(nauczyciele::add);
        for(PracownikNaukowy n: nauczyciele)
        {
            String pom = n.getEmail();
            if(pom.equals(username))
            {
                indeks = n.getId();
            }
        }
        List<Przedmiot> przedmioty = new ArrayList<>();
        List<Przedmiot> przedmioty2 = new ArrayList<>();
        przedmiotRepository.findAll().forEach(przedmioty::add);
        for(Przedmiot p: przedmioty)
        {
            Long pom = p.getProwadzacy().getId();
            if(pom == indeks)
            {
                przedmioty2.add(p);
            }
        }
        model.addAttribute("wystaw", przedmioty2);
        return "naukowy/ocemy/wystaw";
    }
}
