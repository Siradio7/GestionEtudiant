package com.mycompany.gestionetudiant.service;

import com.mycompany.gestionetudiant.dao.IStudent;
import com.mycompany.gestionetudiant.database.Database;
import com.mycompany.gestionetudiant.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentService implements IStudent {
    private final Connection connection = Database.getConnexion();
    private String request;

    public StudentService() throws SQLException {
    }

    @Override
    public Student getStudent(Student student) {
        this.request = "SELECT * FROM students WHERE registration_number = " + student.getRegistrationNumber();

        try {
            Statement statement = this.connection.createStatement();
            ResultSet result = statement.executeQuery(this.request);

            if (result.next()) {
                student.setId(result.getInt("id"));
                student.setName(result.getString("name"));
                student.setDepartment(result.getString("department"));
                student.setSector(result.getString("sector"));
                student.setLevel(result.getString("level"));
                student.setAddress(result.getString("address"));
                student.setPhoneNumber(result.getString("phone_number"));

                return student;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public boolean addStudent(Student student) {
        this.request = "INSERT INTO students VALUES (null, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = this.connection.prepareStatement(this.request);
            statement.setString(1, student.getName());
            statement.setString(2, student.getRegistrationNumber());
            statement.setString(3, student.getDepartment());
            statement.setString(4, student.getSector());
            statement.setString(5, student.getLevel());
            statement.setString(6, student.getAddress());
            statement.setString(7, student.getPhoneNumber());

            final int rowCount = statement.executeUpdate();

            if (rowCount > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    @Override
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        this.request = "SELECT * FROM students";

        try {
            Statement statement = this.connection.createStatement();
            ResultSet result = statement.executeQuery(this.request);

            while (result.next()) {
                Student student = new Student();

                student.setId(result.getInt("id"));
                student.setName(result.getString("name"));
                student.setDepartment(result.getString("department"));
                student.setSector(result.getString("sector"));
                student.setLevel(result.getString("level"));
                student.setAddress(result.getString("address"));
                student.setPhoneNumber(result.getString("phone_number"));

                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return students;
    }

    @Override
    public boolean updateStudent(Student student) {
        this.request = "UPDATE students SET name=?, department=?, sector=?, level=?, address=?, phone_number=? WHERE registration_number=?)";

        try {
            PreparedStatement statement = this.connection.prepareStatement(this.request);
            statement.setString(1, student.getName());
            statement.setString(2, student.getDepartment());
            statement.setString(3, student.getSector());
            statement.setString(4, student.getLevel());
            statement.setString(5, student.getAddress());
            statement.setString(6, student.getPhoneNumber());
            statement.setString(7, student.getRegistrationNumber());

            final int rowCount = statement.executeUpdate();

            if (rowCount > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    @Override
    public boolean removeStudent(Student student) {
        this.request = "DELETE FROM students WHERE registration_number=?";

        try {
            PreparedStatement statement = this.connection.prepareStatement(this.request);
            statement.setString(1, student.getRegistrationNumber());

            final int rowCount = statement.executeUpdate();

            if (rowCount > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
}
