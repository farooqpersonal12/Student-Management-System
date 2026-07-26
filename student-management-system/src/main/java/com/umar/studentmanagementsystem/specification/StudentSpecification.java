package com.umar.studentmanagementsystem.specification;

import com.umar.studentmanagementsystem.Models.Student;
import org.springframework.data.jpa.domain.Specification;

import java.util.Locale;

public class StudentSpecification {

    public static Specification<Student> hasEmail(String email){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("email"),email));
    }

    public  static Specification<Student> hasFirstName(String FirstName){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("firstName")),
                        "%"+FirstName.toLowerCase()+"%"));
    }

    public static Specification<Student> hasPhoneNumber(String phoneNumber) {

        return (root, query, cb) ->
                cb.equal(root.get("phoneNumber"), phoneNumber);

    }

    public static Specification<Student> hasDepartment(String department) {

        return (root, query, cb) ->
                cb.equal(root.get("department"), department);

    }

    public static Specification<Student> hasSemester(Integer semester) {

        return (root, query, cb) ->
                cb.equal(root.get("semester"), semester);

    }


}
