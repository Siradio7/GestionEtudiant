package com.mycompany.gestionetudiant.dao;

import com.mycompany.gestionetudiant.model.Student;

import java.util.List;
import java.util.Optional;

public interface IStudent {
    public Student getStudent(Student student);
    public boolean addStudent(Student student);
    public List<Student> getStudents();
    public boolean updateStudent(Student student);
    public boolean removeStudent(Student student);
}
