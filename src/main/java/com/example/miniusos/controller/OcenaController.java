package com.example.miniusos.controller;

import com.example.miniusos.model.Ocena;
import com.example.miniusos.repositories.OcenaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class OcenaController {
    private final OcenaRepository ocenaRepository;

    public OcenaController(OcenaRepository ocenaRepository) {this.ocenaRepository = ocenaRepository;}

    @RequestMapping("/oceny")
    public String getOcena(Model model)
    {
        model.addAttribute("oceny", ocenaRepository.findAll());

        return "naukowy/oceny/list";
    }

    @RequestMapping(value = "/aktualizujOceny", method = RequestMethod.GET)
    public String getOcena1(Model model)
    {
        List<Ocena> all = ocenaRepository.findAll();

        for (Ocena ocena : all)
        {
            if( ocena.getOcena() == 5) {
                ocena.setOcena(4);
                ocenaRepository.save(ocena);
            }
        }
        model.addAttribute("oceny", ocenaRepository.findAll());
        return "naukowy/oceny/list";
    }
}
