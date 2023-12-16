package org.example.springrestcrudsimpledemo.rest;

import jakarta.annotation.PostConstruct;
import org.example.springrestcrudsimpledemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> studentList;

    @PostConstruct
    private void loadData() {
        studentList = new ArrayList<>();

        studentList.add(new Student("Rick", "Novak"));
        studentList.add(new Student("Susan", "Connor"));
        studentList.add(new Student("Roger", "Lum"));
        studentList.add(new Student("Jeff", "Johnson"));
    }

    @GetMapping("/students")
    public List<Student> getAllStudent() {
        return studentList;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        if (studentId >= studentList.size() || studentId < 0) {
            throw new StudentNotFoundException("Student ID not found: " + studentId);
        }
        return studentList.get(studentId);
    }
}
