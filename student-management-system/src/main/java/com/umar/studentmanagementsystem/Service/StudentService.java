package com.umar.studentmanagementsystem.Service;

import com.umar.studentmanagementsystem.DTOS.StudentRequestDTO;
import com.umar.studentmanagementsystem.DTOS.StudentResponseDTO;
import com.umar.studentmanagementsystem.DTOS.StudentUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface StudentService {

    StudentResponseDTO createStudent(StudentRequestDTO requestDTO);

    Page<StudentResponseDTO> getAllStudents(int page, int size, String sortBy, String direction);

    StudentResponseDTO getStudentById(Long id);

    StudentResponseDTO updateStudent(Long id, StudentUpdateDTO updateDTO);

    Page<StudentResponseDTO> searchStudent(int page, int size,String email,
                                           String FirstName,String PhoneNumber,String department,Integer semester);

    void deleteStudent(Long id);
}