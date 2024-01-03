package org.example.springrestcrudsimpledemo.rest;

import org.example.springrestcrudsimpledemo.entity.Student;
import org.example.springrestcrudsimpledemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private final StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getAllStudent() {
        return studentService.findAll();
    }

    @GetMapping("/students/{studentId}")
    public Optional<Student> getStudentById(@PathVariable int studentId) {
        if (studentId >= studentService.findAll().size() || studentId <= 0) {
            throw new StudentNotFoundException("Student ID not found: " + studentId);
        }
        return studentService.findStudentById(studentId);
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        student.setId(0);
        return studentService.save(student);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable int studentId) {
        studentService.deleteStudent(studentId);
    }
}
