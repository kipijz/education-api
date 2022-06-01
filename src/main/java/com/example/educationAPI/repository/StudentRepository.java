package com.example.educationAPI.repository;

import com.example.educationAPI.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
