package com.example.educationAPI.service;

import com.example.educationAPI.model.Course;
import com.example.educationAPI.model.Student;
import com.example.educationAPI.model.Tutor;
import com.example.educationAPI.repository.CourseRepository;
import com.example.educationAPI.repository.StudentRepository;
import com.example.educationAPI.repository.TutorRepository;
import com.example.educationAPI.request.AddCourseRequest;
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

    public Student addStudent(Student student, String courseName) {
        Course course = courseRepository.findByName(courseName);
        if (course != null) {
            student.addCourseToStudent(course);
            return studentRepository.save(student);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot save student - course not found!");
        }
    }

    public Course addCourse(AddCourseRequest addCourseRequest) {
        Tutor tutor = tutorRepository.findById(addCourseRequest.getTutorId()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot save course - tutor not found!"));

        Course course = Course.builder()
                .name(addCourseRequest.getName())
                .tutor(tutor)
                .build();
        return courseRepository.save(course);
    }

    public Tutor addTutor(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    public Student getStudent(int id) {
        return studentRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot get student - student not found!"));
    }
}
