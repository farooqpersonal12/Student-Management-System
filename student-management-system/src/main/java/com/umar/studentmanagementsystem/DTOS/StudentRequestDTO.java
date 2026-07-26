package com.umar.studentmanagementsystem.DTOS;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDTO {

    @NotBlank(message = "First Name is required")
    @Pattern(
            regexp = "^[A-Za-z .'-]+$",
            message = "First Name can contain only letters, spaces, dots, apostrophes, and hyphens"
    )
    @Size(min = 3, max = 50, message = "First Name must be between 3 and 50 characters")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    @Pattern(
            regexp = "^[A-Za-z .'-]+$",
            message = "Last Name can contain only letters, spaces, dots, apostrophes, and hyphens"
    )
    @Size(min = 3, max = 50, message = "Last Name must be between 3 and 50 characters")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@(gmail|outlook)\\.com$",
            message = "Only Gmail and Outlook email addresses are allowed"
    )
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
            regexp = "Male|Female|Other",
            message = "Gender must be Male, Female, or Other"
    )
    private String gender;

    @NotNull(message = "Address is required")
    @Valid
    private AddressDTO address;

    private String department;

    @NotNull(message = "Semester is required")
    @Min(value = 1, message = "Semester must be at least 1")
    @Max(value = 8, message = "Semester cannot exceed 8")
    private Integer semester;

    @NotNull(message = "CGPA is required")
    @DecimalMin(value = "0.0", message = "CGPA cannot be negative")
    @DecimalMax(value = "10.0", message = "CGPA cannot exceed 10")
    private Double cgpa;
}