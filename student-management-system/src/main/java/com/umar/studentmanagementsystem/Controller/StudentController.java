package com.umar.studentmanagementsystem.Controller;

import com.umar.studentmanagementsystem.DTOS.StudentRequestDTO;
import com.umar.studentmanagementsystem.DTOS.StudentResponseDTO;
import com.umar.studentmanagementsystem.DTOS.StudentUpdateDTO;
import com.umar.studentmanagementsystem.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Create Student
    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent(
            @RequestBody @Valid StudentRequestDTO requestDTO) {

        StudentResponseDTO response = studentService.createStudent(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Get Student by ID
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable Long id) {

        StudentResponseDTO response = studentService.getStudentById(id);
        return ResponseEntity.ok(response);
    }

    // Get All Students with Pagination & Sorting
    @GetMapping
    public Page<StudentResponseDTO> getAllStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        return studentService.getAllStudents(page, size, sortBy, direction);
    }

    // Search Students using Specifications
    @GetMapping("/search")
    public Page<StudentResponseDTO> searchStudent(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String department,
            @RequestParam(required = false) Integer semester) {

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

    // Update Student
    @PutMapping("/{id}")
    public StudentResponseDTO updateStudent(
            @PathVariable Long id,
            @RequestBody @Valid StudentUpdateDTO updateDTO) {

        return studentService.updateStudent(id, updateDTO);
    }

    // Delete Student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {

        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}