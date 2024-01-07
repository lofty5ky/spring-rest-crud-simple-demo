package org.example.springrestcrudsimpledemo.repository;

import org.example.springrestcrudsimpledemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
