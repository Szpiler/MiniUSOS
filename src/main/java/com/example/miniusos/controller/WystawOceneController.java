package com.example.miniusos.controller;

import com.example.miniusos.model.PrzedmiotForm;
import com.example.miniusos.model.WystawOceneForm;
import com.example.miniusos.repositories.PracownikNaukowyRepository;
import com.example.miniusos.repositories.PrzedmiotRepository;
import com.example.miniusos.repositories.StudentRepository;
import com.example.miniusos.service.PrzedmiotService;
import com.example.miniusos.service.WystawOceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WystawOceneController {
    private final PracownikNaukowyRepository pracownikNaukowyRepository;
    private final PrzedmiotRepository przedmiotRepository;
    private final StudentRepository studentRepository;

    @Autowired
    private WystawOceneService wystawOceneService;

    public WystawOceneController(PracownikNaukowyRepository pracownikNaukowyRepository, PrzedmiotRepository przedmiotRepository, StudentRepository studentRepository) {
        this.pracownikNaukowyRepository = pracownikNaukowyRepository;
        this.przedmiotRepository = przedmiotRepository;
        this.studentRepository = studentRepository;
    }


    @RequestMapping("/oceny")
    public String wystawOcene() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().toString();
        if (auth.getAuthorities().toString().equals("[ROLE_STAFF]")) {
            return "naukowy/oceny/wystaw";
        } else
            return "authorize/error";
    }

    @RequestMapping(value = "/oceny", method = RequestMethod.POST)
    public String wystawOcene(@ModelAttribute WystawOceneForm ocena, BindingResult errors, Model model) {

        if (errors.hasErrors()) {
            // tu podajesz do jakiego widoku chcesz przełączyć przy błędzie (błędy typu niepoprawne dane w formularzu)
            return "/przedmiots";
        }

        wystawOceneService.dodaj(ocena);

        return "naukowy/oceny/wystaw";
    }
}
