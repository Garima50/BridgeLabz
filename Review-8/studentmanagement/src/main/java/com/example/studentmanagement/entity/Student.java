package com.example.studentmanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity // marks class as db
@Table(name="students", uniqueConstraints = @UniqueConstraint(columnNames = "email")) //table name in db
public class Student {

    @Id // to make this field primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto generated
    private Integer studentId;

    public String getStudentName() {
        return studentName;
    }

    @NotBlank //cant be blank
    private String studentName;

    @Email //accepts only valid email
    private String email;

    private String course;

    @Min(18) //min age must be 18
    private Integer age;

    public Student() {}

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}
