package com.example.educationAPI.service;

import com.example.educationAPI.model.Course;
import com.example.educationAPI.model.Student;
import com.example.educationAPI.model.Tutor;
import com.example.educationAPI.repository.CourseRepository;
import com.example.educationAPI.repository.StudentRepository;
import com.example.educationAPI.repository.TutorRepository;
import com.example.educationAPI.request.AddCourseRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ApplicationServiceTest {
    @Mock
    private CourseRepository courseRepository;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private TutorRepository tutorRepository;

    @InjectMocks
    private ApplicationService applicationService;

    @DisplayName("Should be able to add course, student and tutor")
    @Test
    void canAddCourseStudentTutor() {
        List<Student> studentList = new ArrayList<>();
        List<Course> courseList = new ArrayList<>();

        Tutor tutor = new Tutor(1, "Tuco", "Salamanca");
        Course course = new Course(1, "PE", studentList, tutor);
        Student student = new Student(1, "JC", "Schneider", courseList);

        given(tutorRepository.save(tutor)).willReturn(tutor);
        given(courseRepository.save(new Course(0, course.getName(), null, tutor))).willReturn(course);
        given(studentRepository.save(student)).willReturn(student);
        given(tutorRepository.findById(tutor.getId())).willReturn(Optional.of(tutor));
        given(courseRepository.findByName(course.getName())).willReturn(course);

        Tutor savedTutor = applicationService.addTutor(tutor);
        Course savedCourse = applicationService.addCourse(new AddCourseRequest(course.getName(), tutor.getId()));
        Student savedStudent = applicationService.addStudent(student, "PE");

        assertThat(savedTutor).isNotNull();
        assertThat(savedCourse).isNotNull();
        assertThat(savedStudent).isNotNull();
    }

    @DisplayName("Should be able to throw when invalid data")
    @Test
    void canThrowWhenInvalidData() {
        List<Student> studentList = new ArrayList<>();
        List<Course> courseList = new ArrayList<>();

        Tutor tutor = new Tutor(1, "Tuco", "Salamanca");
        Course course = new Course(1, "PE", studentList, tutor);
        Student student = new Student(1, "JC", "Schneider", courseList);

        assertThrows(ResponseStatusException.class, () -> {
                    applicationService.addStudent(student, "Course PPP");
                }
        );

        assertThrows(ResponseStatusException.class, () -> {
                    applicationService.addCourse(new AddCourseRequest("Course WWW", 113));
                }
        );

        assertThrows(ResponseStatusException.class, () -> {
                    applicationService.getStudent(3111);
                }
        );
    }
}

