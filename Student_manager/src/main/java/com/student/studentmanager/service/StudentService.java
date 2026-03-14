package com.student.studentmanager.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.student.studentmanager.model.Student;
import com.student.studentmanager.repository.StudentRepository;

@Service
public class StudentService{

 @Autowired
 private StudentRepository repo;

 public List<Student> getStudents(){
  return repo.findAll();
 }

 public Student addStudent(Student s){
  return repo.save(s);
 }

 public void deleteStudent(int id){
  repo.deleteById(id);
 }

}