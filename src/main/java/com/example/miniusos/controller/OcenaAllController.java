package com.example.miniusos.controller;

import com.example.miniusos.repositories.OcenaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OcenaAllController {
    private final OcenaRepository ocenaRepository;

    public OcenaAllController(OcenaRepository ocenaRepository) {this.ocenaRepository = ocenaRepository;}

    @RequestMapping("/ocenyAll")
    public String getOcena(Model model)
    {
        model.addAttribute("oceny", ocenaRepository.findAll());

        return "dziekanat/oceny/list";
    }
}
