package com.example.miniusos.service;

import com.example.miniusos.model.*;
import com.example.miniusos.repositories.PracownikNaukowyRepository;
import com.example.miniusos.repositories.PrzedmiotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrzedmiotService {
    @Autowired
    private PracownikNaukowyRepository pracownikNaukowyRepository;
    @Autowired
    private PrzedmiotRepository przedmiotRepository;

    public Przedmiot add(PrzedmiotForm przedmiotDodany) throws UsernameNotFoundException {

        Przedmiot przedmiot = new Przedmiot();
        przedmiot.setNazwa(przedmiotDodany.getNazwa());
        przedmiot.setMaxIloscStudentow(przedmiotDodany.getMaxIloscStudentow());
        //String imie = przedmiotDodany.getNauczyciel().split(" (?!.* )")[0];
        String nazwisko = przedmiotDodany.getNauczyciel();
        Optional<PracownikNaukowy> wykladowca = pracownikNaukowyRepository.findByNazwisko(nazwisko);
        wykladowca.orElseThrow(() -> new UsernameNotFoundException("Nie znaleziono: " + nazwisko));
        //Optional<PracownikNaukowy> wykladowca = pracownikNaukowyRepository.findById(12L);
        przedmiot.setProwadzacy(wykladowca.get());
        return  przedmiotRepository.save(przedmiot);
    }

    public List<Przedmiot> getPrzedmiotList( int id) throws UsernameNotFoundException {
        List<Przedmiot> przedmioty = przedmiotRepository.findAll();
        List <Przedmiot> tempPrzedmioty = przedmiotRepository.findAll();
        for (Przedmiot przedmiot:tempPrzedmioty)
        {
            if ( Math.toIntExact(przedmiot.getProwadzacy().getId()) != id)
                przedmioty.remove(przedmiot);
        }
        //List<Przedmiot> przedmioty = przedmiotRepository.findByProawdzacy(pracownikNaukowyRepository.findByNazwisko(nazwisko).get());
        return przedmioty;
    }

}
