package org.example.springrestcrudsimpledemo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.springrestcrudsimpledemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaStudentDAO implements StudentDAO {
    private final EntityManager entityManager;

    @Autowired
    public JpaStudentDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAllStudents() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
        return query.getResultList();
    }

    @Override
    public Optional<Student> findStudentById(int id) {
        return Optional.ofNullable(entityManager.find(Student.class, id));
    }

    @Override
    public Student saveNewStudent(Student student){
        return entityManager.merge(student);
    }

    @Override
    public void updateStudentById(int id) {

    }

    @Override
    public void deleteStudentById(int id) {
        Student student = entityManager.find(Student.class, id);

        entityManager.remove(student);
    }
}
