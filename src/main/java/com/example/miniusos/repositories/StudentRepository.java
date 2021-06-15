package com.example.miniusos.repositories;

import com.example.miniusos.model.PracownikNaukowy;
import com.example.miniusos.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByLogin (@Param("login") String login);
}
