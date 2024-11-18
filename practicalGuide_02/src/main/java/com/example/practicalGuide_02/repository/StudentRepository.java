package com.example.practicalGuide_02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.practicalGuide_02.Model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

    List<Student> findByYearsOfEnrollment(int years);

    @Query("SELECT department FROM Student WHERE id = ?1")
    String findDepartmentById(long id);
    
    @Modifying
    
    @Query("DELETE FROM Student WHERE yearsOfEnrollment = ?1")
    void deleteStudentByYearsOfEnrollment(int yearsOfEnrollment);
    
}