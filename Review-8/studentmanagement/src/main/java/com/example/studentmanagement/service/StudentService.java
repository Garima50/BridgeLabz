package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.Student;

import java.util.List;

//method declarations only
public interface StudentService {
    // adds a student
    Student addStudent(Student student);

    // returns all students
    List<Student> getAllStudents();

    //returns a student by ID
    Student getStudentById(Integer id);

    //update existing student by id
    Student updateStudent(Integer id, Student student);

    // deletes a student by id
    void deleteStudent(Integer id);

    //return students of a particular course
    List<Student> getStudentsByCourse(String course);

    //return students whose age > given age
    List<Student> getStudentsByAgeGreaterThan(Integer age);
}
