package com.mycompany.gestionetudiant.dao;

import com.mycompany.gestionetudiant.model.Student;

import java.util.List;
import java.util.Optional;

public interface IStudent {
    public Optional<Student> getStudent(Student student);
    public Student addStudent(Student student);
    public List<Student> getStudents();
    public void updateStudent(Student student);
    public void removeStudent(Student student);
}
