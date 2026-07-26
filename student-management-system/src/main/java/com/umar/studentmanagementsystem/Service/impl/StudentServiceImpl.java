package com.umar.studentmanagementsystem.Service.impl;

import com.umar.studentmanagementsystem.DTOS.StudentRequestDTO;
import com.umar.studentmanagementsystem.DTOS.StudentResponseDTO;
import com.umar.studentmanagementsystem.DTOS.StudentUpdateDTO;
import com.umar.studentmanagementsystem.Exceptions.StudentNotFoundException;
import com.umar.studentmanagementsystem.Models.Student;
import com.umar.studentmanagementsystem.Repository.StudentRepository;
import com.umar.studentmanagementsystem.Service.StudentService;
import com.umar.studentmanagementsystem.specification.StudentSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

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
    public Page<StudentResponseDTO> getAllStudents(int page, int size,String sortBy, String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();
        Pageable pageable =  PageRequest.of(page,size,sort);
        return repository.findAll(pageable)
                .map(student -> modelMapper.map(student, StudentResponseDTO.class));
    }

    @Override
    public StudentResponseDTO getStudentById(Long id) {
        Optional<Student> student = Optional.of(repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student Not Found With given Id:" +id)));
        return modelMapper.map(student,StudentResponseDTO.class);
    }

    @Override
    public StudentResponseDTO updateStudent(Long id, StudentUpdateDTO updateDTO) {
        Student student = repository.findById(id)
                .orElseThrow(()-> new StudentNotFoundException("Student Not Found"));

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
    public Page<StudentResponseDTO> searchStudent(int page, int size,String email,
                                                  String FirstName,String phoneNumber,String department,Integer semester ) {

        Pageable pageable = PageRequest.of(page, size);
        Specification<Student> spec = Specification.unrestricted();

        if(email!=null && !email.isBlank()){
            spec = spec.and(StudentSpecification.hasEmail(email));
        }

        if(FirstName != null && !FirstName.isBlank()){
            spec = spec.and(StudentSpecification.hasFirstName(FirstName));
        }

        if(phoneNumber != null && !phoneNumber.isBlank()){
            spec = spec.and(StudentSpecification.hasPhoneNumber(phoneNumber));
        }

        if(department != null && !department.isBlank()){
            spec = spec.and(StudentSpecification.hasDepartment(department));
        }

        if(semester!=null){
            spec = spec.and(StudentSpecification.hasSemester(semester));
        }
        return repository.findAll(spec,pageable)
                .map(student -> modelMapper.map(student, StudentResponseDTO.class));
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = repository.findById(id)
                .orElseThrow(()-> new StudentNotFoundException("Student Not Found"));

        repository.delete(student);
    }
}
