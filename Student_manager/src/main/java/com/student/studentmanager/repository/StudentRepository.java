package com.student.studentmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.student.studentmanager.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{

}