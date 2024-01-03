package org.example.springrestcrudsimpledemo.service;

import org.example.springrestcrudsimpledemo.dao.StudentDAO;
import org.example.springrestcrudsimpledemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    private final StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAllStudents();
    }

    public Optional<Student> findStudentById(int id) {
        return studentDAO.findStudentById(id);
    }

    @Override
    public Student save(Student student) {
        return studentDAO.saveNewStudent(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentDAO.deleteStudentById(id);
    }
}
