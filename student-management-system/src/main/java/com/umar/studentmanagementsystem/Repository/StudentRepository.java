package com.umar.studentmanagementsystem.Repository;

import com.umar.studentmanagementsystem.Models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentRepository extends
        JpaRepository<Student,Long>,
        JpaSpecificationExecutor<Student> {

}
