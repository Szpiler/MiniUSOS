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
public class PrzedmiotController {
    private final PrzedmiotRepository przedmiotRepository;

    @Autowired
    private PracwonikNaukowyService pracwonikNaukowyService;

    @Autowired
    private PrzedmiotService przedmiotService;

    public PrzedmiotController(PrzedmiotRepository przedmiotRepository) {this.przedmiotRepository = przedmiotRepository;}

    @RequestMapping("/przedmiots")
    public String getPrzedmiots(Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String login = auth.getName();
        int myId = pracwonikNaukowyService.getId(login);

        model.addAttribute("przedmiots", przedmiotService.getPrzedmiotList(myId));

        String role = auth.getAuthorities().toString();
        if(auth.getAuthorities().toString().equals("[ROLE_STAFF]") || auth.getAuthorities().toString().equals("[ROLE_ADMIN]"))
            return ("przedmiots/przedmioty_wykladowcy.html");
        else
        return "authorize/error";
    }

}
