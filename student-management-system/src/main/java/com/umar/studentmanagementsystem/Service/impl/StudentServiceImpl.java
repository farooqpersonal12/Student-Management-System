package com.umar.studentmanagementsystem.Service.impl;

import com.umar.studentmanagementsystem.DTOS.StudentRequestDTO;
import com.umar.studentmanagementsystem.DTOS.StudentResponseDTO;
import com.umar.studentmanagementsystem.DTOS.StudentUpdateDTO;
import com.umar.studentmanagementsystem.Models.Student;
import com.umar.studentmanagementsystem.Repository.StudentRepository;
import com.umar.studentmanagementsystem.Service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;
    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentResponseDTO createStudent(StudentRequestDTO requestDTO) {
        Student student = modelMapper.map(requestDTO,Student.class);
        Student saveStudent = repository.save(student);
        return modelMapper.map(saveStudent, StudentResponseDTO.class);
    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        List<Student> students = repository.findAll();

        return students.stream()
                .map(student -> modelMapper.map(student,StudentResponseDTO.class)).toList();
    }

    @Override
    public StudentResponseDTO getStudentById(Long id) {
        Optional<Student> student = repository.findById(id);
        return modelMapper.map(student,StudentResponseDTO.class);
    }

    @Override
    public StudentResponseDTO updateStudent(Long id, StudentUpdateDTO updateDTO) {
        Student student = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Student Not Found"));

        student.setFirstName(updateDTO.getFirstName());
        student.setLastName(updateDTO.getLastName());
        student.setEmail(updateDTO.getEmail());
        student.setPhoneNumber(updateDTO.getPhoneNumber());
        student.setDateOfBirth(updateDTO.getDateOfBirth());
        student.setGender(updateDTO.getGender());
        student.setDepartment(updateDTO.getDepartment());
        student.setSemester(updateDTO.getSemester());
        student.setCgpa(updateDTO.getCgpa());

        student.getAddress().setPincode(updateDTO.getAddress().getPincode());
        student.getAddress().setState(updateDTO.getAddress().getState());
        student.getAddress().setDistrict(updateDTO.getAddress().getDistrict());

        Student updatedStudent = repository.save(student);

        return modelMapper.map(updatedStudent,StudentResponseDTO.class);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Student Not Found"));

        repository.delete(student);
    }
}
