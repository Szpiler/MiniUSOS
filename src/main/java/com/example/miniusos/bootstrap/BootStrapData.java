package com.example.miniusos.bootstrap;

import com.example.miniusos.model.*;
import com.example.miniusos.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final OcenaRepository ocenaRepository;
    private final PrzedmiotRepository przedmiotRepository;
    private final StudentRepository studentRepository;
    private final PracownikNaukowyRepository pracownikNaukowyRepository;
    private final PracownikDziekanatuRepository pracownikDziekanatuRepository;

    public BootStrapData(OcenaRepository ocenaRepository, PrzedmiotRepository przedmiotRepository, StudentRepository studentRepository,
                         PracownikNaukowyRepository pracownikNaukowyRepository, PracownikDziekanatuRepository pracownikDziekanatuRepository) {
        this.ocenaRepository = ocenaRepository;
        this.przedmiotRepository = przedmiotRepository;
        this.studentRepository = studentRepository;
        this.pracownikNaukowyRepository = pracownikNaukowyRepository;
        this.pracownikDziekanatuRepository = pracownikDziekanatuRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Student piotrek = new Student("Piotrek", "Jaworski", "jp@gmail.com", 123456789, "piti", "1111", 1223348L);
        Przedmiot pJava = new Przedmiot("java", 15);
        Ocena piatka = new Ocena(5);
        PracownikNaukowy profesor = new PracownikNaukowy("Paweł", "Nauczycielski", "pn@gmail.com", 889012, "NauczycielPawel", "1111", 85674L);
        PracownikDziekanatu pracownikD = new PracownikDziekanatu("Gaweł", "Papuga", "gp@gmail.com", 9289353, "PracownikGawel", "1111", 238844L);

        pracownikNaukowyRepository.save(profesor);
        pracownikDziekanatuRepository.save(pracownikD);
        przedmiotRepository.save(pJava);
        studentRepository.save(piotrek);
        ocenaRepository.save(piatka);

        piotrek.getPrzedmioty().add(pJava);
        piotrek.getOceny().add(piatka);
        pJava.getStudenci().add(piotrek);
        pJava.getOceny().add(piatka);
        piatka.setPrzedmiot(pJava);
        piatka.setStudent(piotrek);
        przedmiotRepository.save(pJava);
        studentRepository.save(piotrek);
        ocenaRepository.save(piatka);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Students: " + przedmiotRepository.count());
    }
}
