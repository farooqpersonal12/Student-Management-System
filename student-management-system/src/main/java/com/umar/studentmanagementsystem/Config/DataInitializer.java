package com.umar.studentmanagementsystem.Config;

import com.umar.studentmanagementsystem.Models.Role;
import com.umar.studentmanagementsystem.Models.User;
import com.umar.studentmanagementsystem.Repository.RoleRepository;
import com.umar.studentmanagementsystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) {
        Role adminRole = roleRepository.findByName("ROLE_ADMIN").orElseGet(() -> roleRepository.save(Role.builder().name("ROLE_ADMIN").build()));

        Role userRole = roleRepository.findByName("ROLE_USER").orElseGet(() -> roleRepository.save(Role.builder().name("ROLE_USER").build()));
        if (userRepository.findByuserName("admin").isEmpty()) {

            User admin = User.builder().userName("admin").password(passwordEncoder.encode("admin123")).enabled(true).roles(Set.of(adminRole)).build();

            userRepository.save(admin);
        }
    }
}
