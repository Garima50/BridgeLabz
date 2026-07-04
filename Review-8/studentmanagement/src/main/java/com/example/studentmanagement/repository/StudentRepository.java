package com.example.studentmanagement.repository;

import com.example.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


    @Repository //marks interface as repository layer component
    public interface StudentRepository extends JpaRepository<Student, Integer> {

        //finds all students whose course matches the given
        List<Student> findByCourse(String course);

        //finds all whose age is greater than given age
        List<Student> findByAgeGreaterThan(Integer age);

        //checks whether a student email already exists or not
        boolean existsByEmail(String email);
}
