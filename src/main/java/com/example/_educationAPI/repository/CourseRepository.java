package com.example._educationAPI.repository;

import com.example._educationAPI.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
