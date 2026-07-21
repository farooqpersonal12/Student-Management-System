package com.umar.studentmanagementsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class StudentManagementSystemApplication {
	static private final  Logger LOGGER =
			LoggerFactory.getLogger(StudentManagementSystemApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
		LOGGER.info("Application Started Succesfully");

		
	}

}
