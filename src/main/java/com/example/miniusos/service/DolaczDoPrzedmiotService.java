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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

@Service
public class DolaczDoPrzedmiotService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PrzedmiotRepository przedmiotRepository;

    public void dolaczDoPrzedmiot(DolaczDoPrzedmiotForm dolaczDoPrzedmiotForm) {
        List<Przedmiot> listTemp = przedmiotRepository.findAll();
        List<Przedmiot> list = new ArrayList<Przedmiot>();
        int [] max = new int[6];
        for (int i=0; i<6; i++)
        {
            list.add(listTemp.get(i));
            max[i]=listTemp.get(i).getMaxIloscStudentow() + 1;
        }

        if (dolaczDoPrzedmiotForm.isCheck0())
        {
            list.get(1).setMaxIloscStudentow(max[0]);
            przedmiotRepository.save(list.get(0));
        }

        if (dolaczDoPrzedmiotForm.isCheck1())
        {
            list.get(0).setMaxIloscStudentow(max[1]);
            przedmiotRepository.save(list.get(1));
        }
        if (dolaczDoPrzedmiotForm.isCheck2())
        {
            list.get(2).setMaxIloscStudentow(max[2]);
            przedmiotRepository.save(list.get(2));
        };
        if (dolaczDoPrzedmiotForm.isCheck3())
        {
            list.get(3).setMaxIloscStudentow(max[3]);
            przedmiotRepository.save(list.get(3));
        }
        if (dolaczDoPrzedmiotForm.isCheck4())
        {
            list.get(4).setMaxIloscStudentow(max[4]);
            przedmiotRepository.save(list.get(4));
        }
        if (dolaczDoPrzedmiotForm.isCheck5())
        {
            list.get(5).setMaxIloscStudentow(max[5]);
            przedmiotRepository.save(list.get(5));
        }



        //return przedmiotRepository.save(dolaczDoPrzedmiotForm.getPrzedmiot());
    }
}
