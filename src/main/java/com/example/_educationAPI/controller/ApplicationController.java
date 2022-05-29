package com.example._educationAPI.controller;

import com.example._educationAPI.model.Course;
import com.example._educationAPI.model.Student;
import com.example._educationAPI.model.Tutor;
import com.example._educationAPI.service.ApplicationService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PutMapping("add-student")
    public void addStudent(@RequestBody Student student) {
        applicationService.addStudent(student);
    }

    @PutMapping("add-course")
    public void addCourse(@RequestBody Course course) {
        applicationService.addCourse(course);
    }

    @PutMapping("add-tutor")
    public void addTutor(@RequestBody Tutor tutor) {
        applicationService.addTutor(tutor);
    }

    @GetMapping("get-student/{id}")
    public Student getStudent(@PathVariable("id") int id) {
        return applicationService.getStudent(id);
    }

}
