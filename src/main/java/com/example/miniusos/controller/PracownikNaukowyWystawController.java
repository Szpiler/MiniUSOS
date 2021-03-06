package com.example.miniusos.controller;

import com.example.miniusos.model.PracownikNaukowy;
import com.example.miniusos.model.Przedmiot;
import com.example.miniusos.model.Student;
import com.example.miniusos.model.WystawOceneForm;
import com.example.miniusos.repositories.PracownikNaukowyRepository;
import com.example.miniusos.repositories.PrzedmiotRepository;
import com.example.miniusos.repositories.StudentRepository;
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

import java.util.ArrayList;
import java.util.List;

@Controller
public class PracownikNaukowyWystawController {
    private final PracownikNaukowyRepository pracownikNaukowyRepository;
    private final PrzedmiotRepository przedmiotRepository;
    private final StudentRepository studentRepository;

    @Autowired
    private WystawOceneService wystawOceneService;

    public PracownikNaukowyWystawController(PracownikNaukowyRepository pracownikNaukowyRepository, PrzedmiotRepository przedmiotRepository, StudentRepository studentRepository) {
        this.pracownikNaukowyRepository = pracownikNaukowyRepository;
        this.przedmiotRepository = przedmiotRepository;
        this.studentRepository = studentRepository;
    }

    @RequestMapping("/wystaw")
    public String wystawOcene() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().toString();
        if (auth.getAuthorities().toString().equals("[ROLE_STAFF]")) {
            return "naukowy/oceny/wystaw";
        } else
            return "authorize/error";
    }

    @RequestMapping(value = "/wystaw", method = RequestMethod.POST)
    public String wystawOcene(@ModelAttribute WystawOceneForm ocena, BindingResult errors, Model model) {

        if (errors.hasErrors()) {
            // tu podajesz do jakiego widoku chcesz prze????czy?? przy b????dzie (b????dy typu niepoprawne dane w formularzu)
            return "/przedmiots";
        }

        wystawOceneService.dodaj(ocena);

        return "naukowy/oceny/wystaw";
    }

    @RequestMapping("/wystaw/all")
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
        List<Student> studenci = new ArrayList<>();
        przedmiotRepository.findAll().forEach(przedmioty::add);
        for(Przedmiot p: przedmioty)
        {
            Long pom = p.getProwadzacy().getId();
            if(pom == indeks)
            {
                przedmioty2.add(p);
                for(Student s: p.getStudenci())
                {
                    studenci.add(s);
                }
            }
        }
        model.addAttribute("wystaw", przedmioty2);
        model.addAttribute("studenci", studenci);
        return "naukowy/oceny/wystaw";
    }
}
