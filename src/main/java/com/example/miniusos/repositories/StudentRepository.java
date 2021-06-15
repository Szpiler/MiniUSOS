package com.example.miniusos.repositories;

import com.example.miniusos.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByName(String login);
}
