package com.example.miniusos.repositories;

import com.example.miniusos.model.PracownikNaukowy;
import com.example.miniusos.model.Przedmiot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PrzedmiotRepository extends JpaRepository<Przedmiot, Long> {
    //List<Przedmiot> findByProawdzacy (@Param("prowadzacy") PracownikNaukowy prowadzacy);
    //void updateMaxIloscStudentow(@Param(value="id") Long id, @Param(value = "maxIloscStudentow") int max) ;
}
