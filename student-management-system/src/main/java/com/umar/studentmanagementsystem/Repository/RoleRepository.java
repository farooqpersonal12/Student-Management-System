package com.umar.studentmanagementsystem.Repository;

import com.umar.studentmanagementsystem.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long>
{
    Optional<Role> findByName(String name);
}
