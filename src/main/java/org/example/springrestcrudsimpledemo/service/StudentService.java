package org.example.springrestcrudsimpledemo.service;

import org.example.springrestcrudsimpledemo.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAll();

    Optional<Student> findStudentById(int id);

    Student save(Student student);

    void deleteStudent(int id);
}
