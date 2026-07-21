package com.umar.studentmanagementsystem.Models;

import com.umar.studentmanagementsystem.Models.BaseClass.Address;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    @NotBlank(message = "First Name is required")
    @Pattern(
            regexp = "^[A-Za-z .'-]+$",
            message = "First Name can contain only letters, spaces, dots, apostrophes, and hyphens"
    )
    @Size(min = 3, max = 50)
    private String firstName;

    @NotBlank(message = "Last Name is required")
    @Pattern(
            regexp = "^[A-Za-z .'-]+$",
            message = "Last Name can contain only letters, spaces, dots, apostrophes, and hyphens"
    )
    @Size(min = 3, max = 50)
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@(gmail|outlook)\\.com$",
            message = "Only Gmail and Outlook email addresses are allowed"
    )
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Phone Number is required")
    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Phone number must contain exactly 10 digits"
    )
    private String phoneNumber;

    @NotNull(message = "Date of Birth is required")
    @Past(message = "Date of Birth must be in the past")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Gender is required")
    @Pattern(
            regexp = "Male|Female|Other|MALE|FEMALE|OTHER",
            message = "Gender must be Male, Female, or Other"
    )
    private String gender;

    @Embedded
    @Valid
    private Address address;

    @Nullable
    private String department;

    @NotNull(message = "Semester is required")
    @Min(value = 1, message = "Semester must be at least 1")
    @Max(value = 8, message = "Semester cannot exceed 8")
    private Integer semester;

    @NotNull(message = "CGPA is required")
    @DecimalMin(value = "0.0", message = "CGPA cannot be negative")
    @DecimalMax(value = "10.0", message = "CGPA cannot exceed 10")
    private Double cgpa;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}