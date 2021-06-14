package com.example.miniusos.service;

import com.example.miniusos.model.PracownikNaukowy;
import com.example.miniusos.model.PracownikDziekanatu;
import com.example.miniusos.model.RegisterForm;
import com.example.miniusos.model.Student;
import com.example.miniusos.model.Uzytkownik;
import com.example.miniusos.repositories.PracownikDziekanatuRepository;
import com.example.miniusos.repositories.PracownikNaukowyRepository;
import com.example.miniusos.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.StringTokenizer;

@Service
public class RegisterService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PracownikNaukowyRepository pracownikNaukowyRepository;

    @Autowired
    private PracownikDziekanatuRepository pracownikDziekanatuRepository;

    public Uzytkownik register(RegisterForm registerForm) {

        if(registerForm.getType().equals("student")){
            Student student = new Student();

            Long index = studentRepository.count()+1;

            student.setId(index);
            student.setNumer_telefonu(registerForm.getNumer_telefonu());
            student.setLogin(registerForm.getEmail());
            student.setImie(registerForm.getFirstName());
            student.setNazwisko(registerForm.getLastName());
            student.setEmail(registerForm.getEmail());
            student.setHaslo(registerForm.getPassword());

            return studentRepository.save(student);
        }
        else if (registerForm.getType().equals("pracownik_naukowy"))
        {
            PracownikNaukowy pracownikNaukowy = new PracownikNaukowy();

            Long index = pracownikNaukowyRepository.count()+1;

            pracownikNaukowy.setId(index);
            pracownikNaukowy.setNumer_telefonu(registerForm.getNumer_telefonu());
            pracownikNaukowy.setLogin(registerForm.getEmail());
            pracownikNaukowy.setImie(registerForm.getFirstName());
            pracownikNaukowy.setNazwisko(registerForm.getLastName());
            pracownikNaukowy.setEmail(registerForm.getEmail());
            pracownikNaukowy.setHaslo(registerForm.getPassword());

            return pracownikNaukowyRepository.save(pracownikNaukowy);
        }
        else
        {
            PracownikDziekanatu pracownikDziekanatu = new PracownikDziekanatu();

            Long index = pracownikDziekanatuRepository.count()+1;

            pracownikDziekanatu.setId(index);
            pracownikDziekanatu.setNumer_telefonu(registerForm.getNumer_telefonu());
            pracownikDziekanatu.setLogin(registerForm.getEmail());
            pracownikDziekanatu.setImie(registerForm.getFirstName());
            pracownikDziekanatu.setNazwisko(registerForm.getLastName());
            pracownikDziekanatu.setEmail(registerForm.getEmail());
            pracownikDziekanatu.setHaslo(registerForm.getPassword());

            return pracownikDziekanatuRepository.save(pracownikDziekanatu);
        }

    }
}
