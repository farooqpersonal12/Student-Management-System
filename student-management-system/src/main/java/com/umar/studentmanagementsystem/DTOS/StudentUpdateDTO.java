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
        name = "Student Update Request",
        description = "Request object used to update an existing student's details"
)
public class StudentUpdateDTO {

    @Schema(
            description = "Student's first name",
            example = "Umar",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "First Name is required")
    private String firstName;

    @Schema(
            description = "Student's last name",
            example = "Farooq",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "Last Name is required")
    private String lastName;

    @Schema(
            description = "Student email address",
            example = "umar@gmail.com"
    )
    @Email(message = "Invalid email format")
    private String email;

    @Schema(
            description = "10-digit mobile number",
            example = "9876543210"
    )
    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Phone number must contain exactly 10 digits"
    )
    private String phoneNumber;

    @Schema(
            description = "Student's date of birth (yyyy-MM-dd)",
            example = "2005-01-01"
    )
    @Past(message = "Date of Birth must be in the past")
    private LocalDate dateOfBirth;

    @Schema(
            description = "Student gender",
            allowableValues = {"Male", "Female", "Other"},
            example = "Male"
    )
    private String gender;

    @Schema(
            description = "Student address"
    )
    @Valid
    private AddressDTO address;

    @Schema(
            description = "Department",
            example = "Computer Science"
    )
    private String department;

    @Schema(
            description = "Current semester",
            example = "5",
            minimum = "1",
            maximum = "8"
    )
    @Min(1)
    @Max(8)
    private Integer semester;

    @Schema(
            description = "Current CGPA",
            example = "8.75",
            minimum = "0.0",
            maximum = "10.0"
    )
    @DecimalMin("0.0")
    @DecimalMax("10.0")
    private Double cgpa;
}