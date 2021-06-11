package com.example.miniusos.controller;

import com.example.miniusos.repositories.OcenaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OcenaController {
    private final OcenaRepository ocenaRepository;

    public OcenaController(OcenaRepository ocenaRepository) {this.ocenaRepository = ocenaRepository;}

    @RequestMapping("/oceny")
    public String getOcena(Model model)
    {
        model.addAttribute("oceny", ocenaRepository.findAll());

        return "oceny/list";
    }
}
