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
        // zdecyduj jakim rodzajem będzie nowy użytkownik (PracownikNaukowy czy Student etc...)
        // przykład rejestracji encji Student

        if(registerForm.getType().equals("Student")){
            Student student = new Student();

            Iterator<Student> lastStudent = studentRepository.findAll(Sort.by("id")).iterator();
            Long index = 1L;
            if (lastStudent.hasNext()) {
                index = lastStudent.next().getId() + 1;
            }

            student.setId(index);
            //student.setNumer_telefonu(registerForm.getNumer_telefonu());
            student.setLogin(registerForm.getEmail());
            student.setImie(registerForm.getFirstName());
            student.setNazwisko(registerForm.getLastName());
            student.setEmail(registerForm.getEmail());
            student.setHaslo(registerForm.getPassword());

            return studentRepository.save(student);
        }
        else if (registerForm.getType().equals("Pracownik Naukowy"))
        {
            PracownikNaukowy pracownikNaukowy = new PracownikNaukowy();

            Iterator<PracownikNaukowy> lastPracownikNaukowy = pracownikNaukowyRepository.findAll(Sort.by("id")).iterator();
            Long index = 1L;
            if (lastPracownikNaukowy.hasNext()) {
                index = lastPracownikNaukowy.next().getId() + 1;
            }

            pracownikNaukowy.setId(index);
            //pracownikNaukowy.setNumer_telefonu(registerForm.getNumer_telefonu());
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

            Iterator<PracownikDziekanatu> lastPracownikDziekanatu = pracownikDziekanatuRepository.findAll(Sort.by("id")).iterator();
            Long index = 1L;
            if (lastPracownikDziekanatu.hasNext()) {
                index = lastPracownikDziekanatu.next().getId() + 1;
            }

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
