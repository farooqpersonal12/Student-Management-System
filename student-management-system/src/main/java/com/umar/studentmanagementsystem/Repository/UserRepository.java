package com.umar.studentmanagementsystem.Repository;

import com.umar.studentmanagementsystem.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByuserName(String userName);
}
