package com.klu.controller;

import org.springframework.web.bind.annotation.*;
import com.klu.exception.StudentNotFoundException;

@RestController
public class StudentController {

    @GetMapping("/student/{id}")
    public String getStudent(@PathVariable int id) {

        if(id <= 0){
            throw new StudentNotFoundException("Student ID not found");
        }

        return "Student ID: " + id;
    }
}