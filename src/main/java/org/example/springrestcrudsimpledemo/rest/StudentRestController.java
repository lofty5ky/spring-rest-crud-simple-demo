package org.example.springrestcrudsimpledemo.rest;

import org.example.springrestcrudsimpledemo.dao.JpaStudentDAO;
import org.example.springrestcrudsimpledemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private JpaStudentDAO jpaStudentDAO;

    public StudentRestController(JpaStudentDAO jpaStudentDAO) {
        this.jpaStudentDAO = jpaStudentDAO;
    }

    @GetMapping("/students")
    public List<Student> getAllStudent() {
        return jpaStudentDAO.findAllStudents();
    }

    @GetMapping("/students/{studentId}")
    public Optional<Student> getStudentById(@PathVariable int studentId) {
        if (studentId >= jpaStudentDAO.findAllStudents().size() || studentId <= 0) {
            throw new StudentNotFoundException("Student ID not found: " + studentId);
        }
        return jpaStudentDAO.findStudentById(studentId);
    }
}
