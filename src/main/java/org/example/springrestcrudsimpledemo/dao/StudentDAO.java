package org.example.springrestcrudsimpledemo.dao;

import org.example.springrestcrudsimpledemo.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDAO {
    List<Student> findAllStudents();
    Optional<Student> findStudentById(int id);
}
