package com.umar.studentmanagementsystem.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.umar.studentmanagementsystem.DTOS.StudentRequestDTO;
import com.umar.studentmanagementsystem.DTOS.StudentResponseDTO;
import com.umar.studentmanagementsystem.Models.Student;
import com.umar.studentmanagementsystem.Repository.StudentRepository;
import com.umar.studentmanagementsystem.Service.impl.StudentServiceImpl;
@ExtendWith(MockitoExtension.class)
public class StudentServiceImplTest {

    @Mock
    StudentRepository repository;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    StudentServiceImpl studentServiceImpl;

    @Test
    void testCreateStudent() {

        StudentRequestDTO request = new StudentRequestDTO();
        request.setFirstName("umar");
        request.setLastName("farooq");

        Student student = new Student();
        student.setFirstName("umar");
        student.setLastName("farooq");

        StudentResponseDTO response = new StudentResponseDTO();
        response.setFirstName("umar");
        response.setLastName("farooq");

        when(modelMapper.map(request, Student.class))
                .thenReturn(student);

        when(repository.save(student))
                .thenReturn(student);

        when(modelMapper.map(student, StudentResponseDTO.class))
                .thenReturn(response);

        StudentResponseDTO result =
                studentServiceImpl.createStudent(request);

        assertEquals("umar", result.getFirstName());
        assertEquals("farooq", result.getLastName());

        verify(repository).save(student);
    }
}
