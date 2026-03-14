package com.student.studentmanager.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.student.studentmanager.model.Student;
import com.student.studentmanager.service.StudentService;

@RestController
@CrossOrigin
public class StudentController{

 @Autowired
 private StudentService service;

 @GetMapping("/students")
 public List<Student> getStudents(){
  return service.getStudents();
 }

 @PostMapping("/students")
 public Student addStudent(@RequestBody Student s){
  return service.addStudent(s);
 }

 @DeleteMapping("/students/{id}")
 public void deleteStudent(@PathVariable int id){
  service.deleteStudent(id);
 }

}