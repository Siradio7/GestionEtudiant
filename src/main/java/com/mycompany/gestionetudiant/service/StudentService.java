package com.mycompany.gestionetudiant.service;

import com.mycompany.gestionetudiant.dao.IStudent;
import com.mycompany.gestionetudiant.model.Student;

import java.util.List;
import java.util.Optional;

public class StudentService implements IStudent {
    @Override
    public Optional<Student> getStudent(Student student) {
        return Optional.empty();
    }

    @Override
    public Student addStudent(Student student) {
        return null;
    }

    @Override
    public List<Student> getStudents() {
        return null;
    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void removeStudent(Student student) {

    }
}
