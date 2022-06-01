package com.example.educationAPI.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCourseRequest {
    private String name;
    private int tutorId;
}
