package com.example.miniusos.service;

import com.example.miniusos.model.PracownikNaukowy;
import com.example.miniusos.model.Przedmiot;
import com.example.miniusos.model.PrzedmiotForm;
import com.example.miniusos.repositories.PracownikNaukowyRepository;
import com.example.miniusos.repositories.PrzedmiotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PracwonikNaukowyService {
    @Autowired
    private PracownikNaukowyRepository pracownikNaukowyRepository;
    @Autowired
    private PrzedmiotRepository przedmiotRepository;

    public int getId(String mail) throws UsernameNotFoundException {

        List<PracownikNaukowy> pracownicy = pracownikNaukowyRepository.findAll();
        List<PracownikNaukowy> tempPracownicy = pracownikNaukowyRepository.findAll();
        int id=0;
        for (PracownikNaukowy pracownik:tempPracownicy)
        {
            if (pracownik.getEmail().equals(mail) ) {
                id = Math.toIntExact(pracownik.getId());
                break;
            }
        }
        //List<Przedmiot> przedmioty = przedmiotRepository.findByProawdzacy(pracownikNaukowyRepository.findByNazwisko(nazwisko).get());
        return id;
    }



}
