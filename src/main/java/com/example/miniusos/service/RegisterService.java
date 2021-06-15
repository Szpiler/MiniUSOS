package com.example.miniusos.service;

import com.example.miniusos.model.*;
import com.example.miniusos.repositories.PracownikDziekanatuRepository;
import com.example.miniusos.repositories.PracownikNaukowyRepository;
import com.example.miniusos.repositories.StudentRepository;
import com.example.miniusos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PracownikNaukowyRepository pracownikNaukowyRepository;

    @Autowired
    private PracownikDziekanatuRepository pracownikDziekanatuRepository;

    @Autowired
    private UserRepository userRepository;

    public Uzytkownik register(RegisterForm registerForm) {

        User user = new User();
        if(registerForm.getType().equals("student")){
            Student student = new Student();

            Long index = studentRepository.count()+1;

            user.setActive(true);
            user.setPassword(registerForm.getPassword());
            user.setRoles("ROLE_USER");
            user.setUserName(registerForm.getEmail());

            student.setId(index);
            student.setNumer_telefonu(registerForm.getNumer_telefonu());
            student.setLogin(registerForm.getEmail());
            student.setImie(registerForm.getFirstName());
            student.setNazwisko(registerForm.getLastName());
            student.setEmail(registerForm.getEmail());
            student.setHaslo(registerForm.getPassword());

            userRepository.save(user);
            return studentRepository.save(student);
        }
        else if (registerForm.getType().equals("pracownik_naukowy"))
        {
            PracownikNaukowy pracownikNaukowy = new PracownikNaukowy();

            Long index = pracownikNaukowyRepository.count()+1;

            user.setActive(true);
            user.setPassword(registerForm.getPassword());
            user.setRoles("ROLE_STAFF");
            user.setUserName(registerForm.getEmail());

            pracownikNaukowy.setId(index);
            pracownikNaukowy.setNumer_telefonu(registerForm.getNumer_telefonu());
            pracownikNaukowy.setLogin(registerForm.getEmail());
            pracownikNaukowy.setImie(registerForm.getFirstName());
            pracownikNaukowy.setNazwisko(registerForm.getLastName());
            pracownikNaukowy.setEmail(registerForm.getEmail());
            pracownikNaukowy.setHaslo(registerForm.getPassword());

            userRepository.save(user);

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

            user.setActive(true);
            user.setPassword(registerForm.getPassword());
            user.setRoles("ROLE_ADMIN");
            user.setUserName(registerForm.getEmail());

            pracownikDziekanatu.setId(index);
            pracownikDziekanatu.setNumer_telefonu(registerForm.getNumer_telefonu());
            pracownikDziekanatu.setLogin(registerForm.getEmail());
            pracownikDziekanatu.setImie(registerForm.getFirstName());
            pracownikDziekanatu.setNazwisko(registerForm.getLastName());
            pracownikDziekanatu.setEmail(registerForm.getEmail());
            pracownikDziekanatu.setHaslo(registerForm.getPassword());

            userRepository.save(user);

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
