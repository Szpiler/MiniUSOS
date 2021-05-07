package com.example.miniusos.bootstrap;

import com.example.miniusos.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final OcenaRepository ocenaRepository;
    private final PrzedmiotRepository przedmiotRepository;
    private final StudentRepository studentRepository;

    public BootStrapData(OcenaRepository ocenaRepository, PrzedmiotRepository przedmiotRepository, StudentRepository studentRepository) {
        this.ocenaRepository = ocenaRepository;
        this.przedmiotRepository = przedmiotRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

 //       Student piotrek = new Student("Piotrek", "Jaworski", "jp@gmail.com", 123456789, "piti", "1111", 1223348L);
//       Przedmiot java = new Przedmiot("java", 15);
 //       piotrek.getPrzedmioty().add(java);
//        java.getStudenci().add(piotrek);
//
//        studentRepository.save(piotrek);
//        przedmiotRepository.save(java);
//
//        System.out.println("Started in Bootstrap");
//        System.out.println("Number of Students: " + przedmiotRepository.count());
    }
}
