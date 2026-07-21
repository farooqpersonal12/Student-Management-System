package com.umar.studentmanagementsystem.DTOS;

import com.umar.studentmanagementsystem.DTOS.AddressDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentUpdateDTO {

    @NotBlank(message = "First Name is required")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    private String lastName;

    @Email(message = "Invalid email format")
    private String email;

    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Phone number must contain exactly 10 digits"
    )
    private String phoneNumber;

    @Past(message = "Date of Birth must be in the past")
    private LocalDate dateOfBirth;

    private String gender;

    @Valid
    private AddressDTO address;

    private String department;

    @Min(1)
    @Max(8)
    private Integer semester;

    @DecimalMin("0.0")
    @DecimalMax("10.0")
    private Double cgpa;
}