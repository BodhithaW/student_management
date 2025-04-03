package com.example.student_manage.controller;
import com.example.student_manage.model.Student;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.student_manage.Repository.StudentRepository;


import java.util.List;

@RestController
@RequestMapping("api/student")

public class StudentController {
        @Autowired
    private StudentRepository studentRepository;

    // Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Add a new student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }
}
