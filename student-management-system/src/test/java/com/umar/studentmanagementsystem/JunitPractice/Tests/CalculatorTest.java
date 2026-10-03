package com.umar.studentmanagementsystem.JunitPractice.Tests;

import com.umar.studentmanagementsystem.JunitPractice.classes.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.nullable;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class CalculatorTest {

    static Calculator locaCalculator;
    Calculator calculator;

    @BeforeAll
    static void creatingCalculatorObjOnce() {
        locaCalculator = new Calculator();
        System.out.println("Created local calculator object first");
    }

    @BeforeEach
    void objcreation() {
        calculator = new Calculator();
        System.out.println("Calclualtor Obj created");
    }

    @Test
    void addTest() {
        int result = calculator.add(1, 2);

        assertEquals(3, result);

    }

    @Test
    void isEvenTest() {
        boolean result = calculator.isEven(4);

        assertEquals(true, result);
    }

    @AfterEach
    void objDestroyed() {
        calculator = null;
        System.out.println("calculator Obj destroyed");
    }

    @AfterAll
    static void destroyingCalculatorObjOnce() {
        locaCalculator = null;
        System.out.println("destroyed local calculator at last");
    }

}
