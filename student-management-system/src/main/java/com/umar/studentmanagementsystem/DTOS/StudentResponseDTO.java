package com.umar.studentmanagementsystem.DTOS;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name = "Student Response",
        description = "Response object containing student details"
)
public class StudentResponseDTO {

    @Schema(
            description = "Unique identifier of the student",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Student's first name",
            example = "Umar"
    )
    private String firstName;

    @Schema(
            description = "Student's last name",
            example = "Farooq"
    )
    private String lastName;

    @Schema(
            description = "Student's email address",
            example = "umar@gmail.com"
    )
    private String email;

    @Schema(
            description = "Student's 10-digit mobile number",
            example = "9876543210"
    )
    private String phoneNumber;

    @Schema(
            description = "Department in which the student is enrolled",
            example = "Computer Science"
    )
    private String department;

    @Schema(
            description = "Current semester of the student",
            example = "5"
    )
    private Integer semester;

    @Schema(
            description = "Current CGPA of the student",
            example = "8.75"
    )
    private Double cgpa;
}