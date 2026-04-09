package com.skill16.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Student entity representing a student in the management system")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Auto-generated unique ID of the student", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Schema(description = "Full name of the student", example = "Alice Johnson", required = true)
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    @Column(unique = true)
    @Schema(description = "Unique email address of the student", example = "alice@college.edu", required = true)
    private String email;

    @NotBlank(message = "Course is required")
    @Schema(description = "Course enrolled by the student", example = "Computer Science", required = true)
    private String course;
}
