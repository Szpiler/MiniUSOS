package com.example.miniusos.controller;

import com.example.miniusos.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {this.studentRepository = studentRepository;}

    @RequestMapping("/students")
    public String getStudents(Model model)
    {
        model.addAttribute("students", studentRepository.findAll());

        return "students/list";
    }
}
