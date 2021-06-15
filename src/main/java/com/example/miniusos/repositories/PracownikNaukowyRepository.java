package com.example.miniusos.repositories;

import com.example.miniusos.model.PracownikNaukowy;
import com.example.miniusos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PracownikNaukowyRepository extends JpaRepository<PracownikNaukowy, Long> {
    Optional<PracownikNaukowy> findByNazwisko (@Param("nazwisko") String urName);
}
