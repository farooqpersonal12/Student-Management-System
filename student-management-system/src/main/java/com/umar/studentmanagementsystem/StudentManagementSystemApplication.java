package com.umar.studentmanagementsystem;

import com.umar.studentmanagementsystem.Models.BaseClass.Address;
import com.umar.studentmanagementsystem.Models.Student;
import net.datafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import com.umar.studentmanagementsystem.Repository.StudentRepository;

import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class StudentManagementSystemApplication {
	static private final  Logger LOGGER =
			LoggerFactory.getLogger(StudentManagementSystemApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
		LOGGER.info("Application Started Succesfully");
	}
}
