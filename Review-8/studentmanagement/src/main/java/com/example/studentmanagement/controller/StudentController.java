package com.example.studentmanagement.controller;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//receives Http requests and return json responses
@RestController
@RequestMapping("/students") //base url for all APIs
@Validated //for validation support
public class StudentController {
    //injects service obj
    @Autowired
    private StudentService studentService;

    // POST API to add a new student
    @PostMapping
    public Student addStudent(@Valid @RequestBody Student student)//converts json into student obj
    {
        return studentService.addStudent(student);
    }

    // GET API to fetch all students (/students)
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // GET API to fetch by id
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) //gets id from url
    {
        return studentService.getStudentById(id);
    }

    // PUT API to update a student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id, @Valid @RequestBody Student student)
    //converts json to student obj, and triggers validations
    {
        return studentService.updateStudent(id, student);
    }

    // DELETE API to delete a student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return "Student deleted successfully!"; //success msg
    }

    // GET API to fetch students by course
    @GetMapping("/course/{course}")
    public List<Student> getStudentsByCourse(@PathVariable String course) {
        return studentService.getStudentsByCourse(course);
    }

    // GET API to fetch students whose age is greater than given age
    @GetMapping("/age/{age}")
    public List<Student> getStudentsByAgeGreaterThan(@PathVariable Integer age)
    {
        return studentService.getStudentsByAgeGreaterThan(age);
    }
}
