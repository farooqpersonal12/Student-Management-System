package com.umar.studentmanagementsystem.Repository;

import com.umar.studentmanagementsystem.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
