package com.springsec.springsecdemo.controller;

import com.springsec.springsecdemo.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>(
        List.of(
            new Student(1, "John Doe", "Java"),
            new Student(2, "Jane Smith", "Python"),
            new Student(3, "Alice Johnson", "JavaScript")
        )
    );

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return students;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        students.removeIf(student -> student.getId() == id);
        return "Student with ID " + id + " deleted successfully.";
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
//        return request.getAttribute(CsrfToken.class.getName()) != null
//            ? (CsrfToken) request.getAttribute(CsrfToken.class.getName())
//            : null;
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
