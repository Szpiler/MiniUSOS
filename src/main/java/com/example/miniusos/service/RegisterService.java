package com.example.miniusos.service;

import com.example.miniusos.model.RegisterForm;
import com.example.miniusos.model.Student;
import com.example.miniusos.model.Uzytkownik;
import com.example.miniusos.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class RegisterService {
    @Autowired
    private StudentRepository studentRepository;

    public Uzytkownik register(RegisterForm registerForm) {
        // zdecyduj jakim rodzajem będzie nowy użytkownik (PracownikNaukowy czy Student etc...)
        // przykład rejestracji encji Student

        Student student = new Student();
        // Tu trzeba wymyślić sposób generowania indeksu, prowizorycznie pobieram najwyższe z bazy i dodaje nowe (nie wydajne rozwiązanie)
        Iterator<Student> lastStudent = studentRepository.findAll(Sort.by("id")).iterator();
        Long index = 1L;
        if (lastStudent.hasNext()) {
            index = lastStudent.next().getId() + 1;
        }

        student.setId(index);
        student.setLogin(registerForm.getEmail());
        student.setImie(registerForm.getFirstName());
        student.setNazwisko(registerForm.getLastName());
        student.setEmail(registerForm.getEmail());
        student.setHaslo(registerForm.getPassword());

        return studentRepository.save(student);
    }
}
