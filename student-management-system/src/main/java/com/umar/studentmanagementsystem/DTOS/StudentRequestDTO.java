package com.umar.studentmanagementsystem.DTOS;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name = "Student Request",
        description = "Request object used to create a new student"
)
public class StudentRequestDTO {

    @Schema(
            description = "Student's first name",
            example = "Umar",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "First Name is required")
    @Pattern(
            regexp = "^[A-Za-z .'-]+$",
            message = "First Name can contain only letters, spaces, dots, apostrophes, and hyphens"
    )
    @Size(min = 3, max = 50, message = "First Name must be between 3 and 50 characters")
    private String firstName;

    @Schema(
            description = "Student's last name",
            example = "Farooq",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "Last Name is required")
    @Pattern(
            regexp = "^[A-Za-z .'-]+$",
            message = "Last Name can contain only letters, spaces, dots, apostrophes, and hyphens"
    )
    @Size(min = 3, max = 50, message = "Last Name must be between 3 and 50 characters")
    private String lastName;

    @Schema(
            description = "Student email address",
            example = "umar@gmail.com",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@(gmail|outlook)\\.com$",
            message = "Only Gmail and Outlook email addresses are allowed"
    )
    private String email;

    @Schema(
            description = "10-digit mobile number",
            example = "9876543210",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "Phone Number is required")
    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Phone number must contain exactly 10 digits"
    )
    private String phoneNumber;

    @Schema(
            description = "Date of Birth (yyyy-MM-dd)",
            example = "2005-01-01",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "Date of Birth is required")
    @Past(message = "Date of Birth must be in the past")
    private LocalDate dateOfBirth;

    @Schema(
            description = "Gender",
            allowableValues = {"Male", "Female", "Other"},
            example = "Male",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "Gender is required")
    @Pattern(
            regexp = "Male|Female|Other",
            message = "Gender must be Male, Female, or Other"
    )
    private String gender;

    @Schema(
            description = "Student address",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "Address is required")
    @Valid
    private AddressDTO address;

    @Schema(
            description = "Department",
            example = "Computer Science"
    )
    private String department;

    @Schema(
            description = "Current semester",
            example = "3",
            minimum = "1",
            maximum = "8",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "Semester is required")
    @Min(value = 1, message = "Semester must be at least 1")
    @Max(value = 8, message = "Semester cannot exceed 8")
    private Integer semester;

    @Schema(
            description = "Current CGPA",
            example = "8.75",
            minimum = "0.0",
            maximum = "10.0",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "CGPA is required")
    @DecimalMin(value = "0.0", message = "CGPA cannot be negative")
    @DecimalMax(value = "10.0", message = "CGPA cannot exceed 10")
    private Double cgpa;
}