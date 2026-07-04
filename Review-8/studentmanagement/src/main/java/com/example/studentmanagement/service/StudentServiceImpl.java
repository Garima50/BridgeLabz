package com.example.studentmanagement.service;


import com.example.studentmanagement.exception.DuplicateEmailException;
import com.example.studentmanagement.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

// service layer
// business logic is written here
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired //injects repo obj
    private StudentRepository studentRepository;

    @Override //to add a new student it checks with email first
    public Student addStudent(Student student) {
        if(studentRepository.existsByEmail(student.getEmail())) {
            throw new DuplicateEmailException("Email already exists!");
        }
        return studentRepository.save(student);
    }

    @Override //returns all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override //returns student by ID
    public Student getStudentById(Integer id) {
        //findById returns an Optional object because the student may or may not exist
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()) { //checks if student present or not
            return student.get();
        }
        throw new StudentNotFoundException("Student not found."); //custom exception
    }

    @Override //updated student details
    public Student updateStudent(Integer id, Student updatedstudent) {
        Student student = getStudentById(id);

        student.setStudentName(updatedstudent.getStudentName());
        student.setEmail(updatedstudent.getEmail());
        student.setCourse(updatedstudent.getCourse());
        student.setAge(updatedstudent.getAge());

        return studentRepository.save(student);
    }

    @Override //deletes a student
    public void deleteStudent(Integer id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
    }

    @Override //return students by course
    public List<Student> getStudentsByCourse(String course) {
        return studentRepository.findByCourse(course);
    }

    @Override //returns students greater age than given age
    public List<Student> getStudentsByAgeGreaterThan(Integer age) {
        return studentRepository.findByAgeGreaterThan(age);
    }
}
