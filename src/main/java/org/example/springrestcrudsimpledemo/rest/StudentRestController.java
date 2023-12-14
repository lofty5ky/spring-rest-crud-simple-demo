package org.example.springrestcrudsimpledemo.rest;

import jakarta.annotation.PostConstruct;
import org.example.springrestcrudsimpledemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> studentList;

    @PostConstruct
    private void loadData(){
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

    // catch student not found exception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handlerIDNotFoundException(StudentNotFoundException ex) {
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // catch for other exception can happen
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handlerOtherException(Exception ex) {
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
