// package com.example.student_manage.controller;
// import com.example.student_manage.model.Student;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.beans.factory.annotation.Autowired;
// import com.example.student_manage.Repository.StudentRepository;


// import java.util.List;

// @RestController
// @RequestMapping("api/student")

// public class StudentController {
//         @Autowired
//     private StudentRepository studentRepository;

//     // Get all students
//     @GetMapping
//     public List<Student> getAllStudents() {
//         return studentRepository.findAll();
//     }

//     // Add a new student
//     @PostMapping
//     public Student addStudent(@RequestBody Student student) {
//         return studentRepository.save(student);
//     }
// }


package com.example.student_manage.controller;

import com.example.student_manage.model.Student;
import com.example.student_manage.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.student_manage.model.ModuleRequest;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // Register a new student
    @PostMapping("/register")
    public Student registerStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // Register a module for a student
    @PostMapping("/{id}/modules")
    public String registerModule(@PathVariable String id, @RequestBody ModuleRequest moduleRequest) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.registerModule(moduleRequest.getModuleCode());
            studentRepository.save(student);
            return "Module " + moduleRequest.getModuleCode() + " registered successfully for " + student.getName();
        } else {
            return "Student not found";
        }
    }

    // ✅ Get all registered modules for a student
    @GetMapping("/{id}/modules")
    public List<String> getStudentModules(@PathVariable String id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            return studentOptional.get().getModules(); // Return list of registered modules
        } else {
            throw new RuntimeException("Student not found");
        }
    }

    // Get all students
    @GetMapping
    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
