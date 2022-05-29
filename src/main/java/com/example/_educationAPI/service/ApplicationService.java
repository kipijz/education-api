package com.example._educationAPI.service;

import com.example._educationAPI.model.Course;
import com.example._educationAPI.model.Student;
import com.example._educationAPI.model.Tutor;
import com.example._educationAPI.repository.CourseRepository;
import com.example._educationAPI.repository.StudentRepository;
import com.example._educationAPI.repository.TutorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ApplicationService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final TutorRepository tutorRepository;

    public ApplicationService(CourseRepository courseRepository, StudentRepository studentRepository, TutorRepository tutorRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.tutorRepository = tutorRepository;
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void addTutor(Tutor tutor) {
        tutorRepository.save(tutor);
    }

    public Student getStudent(int id) {
        return studentRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
