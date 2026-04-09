package com.skill16.config;

import com.skill16.entity.Student;
import com.skill16.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) {
        if (studentRepository.count() == 0) {
            studentRepository.save(Student.builder()
                    .name("Alice Johnson")
                    .email("alice@college.edu")
                    .course("Computer Science")
                    .build());
            studentRepository.save(Student.builder()
                    .name("Bob Smith")
                    .email("bob@college.edu")
                    .course("Information Technology")
                    .build());
            studentRepository.save(Student.builder()
                    .name("Carol White")
                    .email("carol@college.edu")
                    .course("Data Science")
                    .build());
            System.out.println("✅ Sample students seeded successfully.");
            System.out.println("📄 Swagger UI →  http://localhost:8080/swagger-ui/index.html");
            System.out.println("🗄  H2 Console →  http://localhost:8080/h2-console");
        }
    }
}
