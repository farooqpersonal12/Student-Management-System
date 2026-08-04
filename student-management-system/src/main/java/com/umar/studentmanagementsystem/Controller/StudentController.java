package com.umar.studentmanagementsystem.Controller;

import com.umar.studentmanagementsystem.DTOS.StudentRequestDTO;
import com.umar.studentmanagementsystem.DTOS.StudentResponseDTO;
import com.umar.studentmanagementsystem.DTOS.StudentUpdateDTO;
import com.umar.studentmanagementsystem.Service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@Tag(
        name = "Student Management",
        description = "APIs for managing student records"
)
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @Operation(
            summary = "Create Student",
            description = "Creates a new student after validating the request data."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Student created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "409", description = "Student already exists"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent(

            @RequestBody(
                    description = "Student details required for registration",
                    required = true,
                    content = @Content
            )
            @Valid
            @org.springframework.web.bind.annotation.RequestBody
            StudentRequestDTO requestDTO) {

        StudentResponseDTO response = studentService.createStudent(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @Operation(
            summary = "Get Student By ID",
            description = "Fetches a student using the unique student ID."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Student found"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(

            @Parameter(
                    description = "Unique ID of the student",
                    example = "1"
            )
            @PathVariable Long id) {

        StudentResponseDTO response = studentService.getStudentById(id);
        return ResponseEntity.ok(response);
    }


    @Operation(
            summary = "Get All Students",
            description = "Returns a paginated list of all students."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Students retrieved successfully")
    })
    @GetMapping
    public Page<StudentResponseDTO> getAllStudents(

            @Parameter(description = "Page number", example = "0")
            @RequestParam(defaultValue = "0")
            int page,

            @Parameter(description = "Number of records per page", example = "10")
            @RequestParam(defaultValue = "10")
            int size,

            @Parameter(description = "Field used for sorting", example = "id")
            @RequestParam(defaultValue = "id")
            String sortBy,

            @Parameter(description = "Sorting direction", example = "asc")
            @RequestParam(defaultValue = "asc")
            String direction) {

        return studentService.getAllStudents(page, size, sortBy, direction);
    }


    @Operation(
            summary = "Search Students",
            description = "Searches students using one or more search criteria."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Search completed successfully")
    })
    @GetMapping("/search")
    public Page<StudentResponseDTO> searchStudent(

            @Parameter(description = "Page number", example = "0")
            @RequestParam(defaultValue = "0")
            int page,

            @Parameter(description = "Number of records per page", example = "10")
            @RequestParam(defaultValue = "10")
            int size,

            @Parameter(description = "Student email", example = "john@gmail.com")
            @RequestParam(required = false)
            String email,

            @Parameter(description = "Student first name", example = "John")
            @RequestParam(required = false)
            String firstName,

            @Parameter(description = "Phone number", example = "9876543210")
            @RequestParam(required = false)
            String phoneNumber,

            @Parameter(description = "Department name", example = "Computer Science")
            @RequestParam(required = false)
            String department,

            @Parameter(description = "Semester", example = "5")
            @RequestParam(required = false)
            Integer semester) {

        return studentService.searchStudent(
                page,
                size,
                email,
                firstName,
                phoneNumber,
                department,
                semester
        );
    }


    @Operation(
            summary = "Update Student",
            description = "Updates an existing student's details."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Student updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request data"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @PutMapping("/{id}")
    public StudentResponseDTO updateStudent(

            @Parameter(
                    description = "Unique ID of the student",
                    example = "1"
            )
            @PathVariable Long id,

            @RequestBody(
                    description = "Updated student information",
                    required = true,
                    content = @Content
            )
            @Valid
            @org.springframework.web.bind.annotation.RequestBody
            StudentUpdateDTO updateDTO) {

        return studentService.updateStudent(id, updateDTO);
    }


    @Operation(
            summary = "Delete Student",
            description = "Deletes a student using the given student ID."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Student deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(

            @Parameter(
                    description = "Unique ID of the student",
                    example = "1"
            )
            @PathVariable Long id) {

        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}