package com.example.miniusos.service;

import com.example.miniusos.model.PracownikNaukowy;
import com.example.miniusos.model.PracownikDziekanatu;
import com.example.miniusos.model.RegisterForm;
import com.example.miniusos.model.Student;
import com.example.miniusos.model.User;
import com.example.miniusos.model.Przedmiot;
import com.example.miniusos.model.DolaczDoPrzedmiotForm;
import com.example.miniusos.model.*;

import com.example.miniusos.service.DolaczDoPrzedmiotService;
import com.example.miniusos.repositories.PrzedmiotRepository;
import com.example.miniusos.repositories.UserRepository;
import com.example.miniusos.repositories.PracownikDziekanatuRepository;
import com.example.miniusos.repositories.PracownikNaukowyRepository;
import com.example.miniusos.repositories.StudentRepository;
import com.example.miniusos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.StringTokenizer;

@Service
public class DolaczDoPrzedmiotService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PrzedmiotRepository przedmiotRepository;

    public Przedmiot dolaczDoPrzedmiot(DolaczDoPrzedmiotForm dolaczDoPrzedmiotForm) {



        return przedmiotRepository.save(dolaczDoPrzedmiotForm.getPrzedmiot());
    }
}
