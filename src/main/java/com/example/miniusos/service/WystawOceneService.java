package com.example.miniusos.service;

import com.example.miniusos.model.*;
import com.example.miniusos.repositories.PracownikNaukowyRepository;
import com.example.miniusos.repositories.PrzedmiotRepository;
import com.example.miniusos.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WystawOceneService {
    @Autowired
    private PracownikNaukowyRepository pracownikNaukowyRepository;
    @Autowired
    private PrzedmiotRepository przedmiotRepository;
    @Autowired
    private StudentRepository studentRepository;

    public void dodaj(WystawOceneForm ocenaDodana) throws UsernameNotFoundException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Long indeks = -1L;
        String username = auth.getName();
        List<PracownikNaukowy> nauczyciele = new ArrayList<>();
        pracownikNaukowyRepository.findAll().forEach(nauczyciele::add);
        for (PracownikNaukowy n:nauczyciele)
        {
            String pom = n.getLogin();
            if(pom.equals(username))
            {
                indeks = n.getId();
            }
        }
        List<Przedmiot> przedmiots = new ArrayList<>();
        List<Przedmiot> przedmiots1 = new ArrayList<>();
        przedmiotRepository.findAll().forEach(przedmiots::add);
        for (Przedmiot p:przedmiots)
        {
            Long pom = p.getProwadzacy().getId();
            if(pom == indeks)
            {
                przedmiots1.add(p);
            }
        }
        Long indeks2 = -1L;
        for (Przedmiot p: przedmiots1)
        {
            Long pom = p.getId();
            if(pom == ocenaDodana.getIdPrzedmiotu())
            {
                indeks2 = pom;
            }
        }
        Long indek3 = -1L;
        List<Student> studenci = new ArrayList<>();
        studentRepository.findAll().forEach(studenci::add);
        for(Student s:studenci)
        {
            Long pom = s.getId();
            if(pom == ocenaDodana.getStudentindeks())
            {
                Ocena ocena = new Ocena(ocenaDodana.getOcena());
                s.getOceny().add(ocena);
                studentRepository.save(s);
            }
        }
    }
}
