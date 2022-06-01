package com.example.educationAPI.controller;

import com.example.educationAPI.model.Course;
import com.example.educationAPI.model.Student;
import com.example.educationAPI.model.Tutor;
import com.example.educationAPI.request.AddCourseRequest;
import com.example.educationAPI.service.ApplicationService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PutMapping("add-student/{courseName}")
    public Student addStudent(@PathVariable String courseName, @RequestBody Student student) {
        return applicationService.addStudent(student, courseName);
    }

    @PutMapping("add-course")
    public Course addCourse(@RequestBody AddCourseRequest addCourseRequest) {
        return applicationService.addCourse(addCourseRequest);
    }

    @PutMapping("add-tutor")
    public Tutor addTutor(@RequestBody Tutor tutor) {
        return applicationService.addTutor(tutor);
    }

    @GetMapping("get-student/{id}")
    public Student getStudent(@PathVariable int id) {
        return applicationService.getStudent(id);
    }
}

