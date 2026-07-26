package com.umar.studentmanagementsystem.Exceptions;

public class StudentNotFoundException extends RuntimeException  {
    public StudentNotFoundException(String message){
        super(message);
    }
}
