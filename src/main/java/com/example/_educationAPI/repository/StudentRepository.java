package com.example._educationAPI.repository;

import com.example._educationAPI.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
