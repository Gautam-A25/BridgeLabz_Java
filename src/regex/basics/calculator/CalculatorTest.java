package javacollectionstreams.regex.basics.calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    // Creating Calculator object for testing
    Calculator calculator = new Calculator();

    // Test for addition
    @Test
    void testAdd() {
        assertEquals(10, calculator.add(5, 5));
    }

    // Test for subtraction
    @Test
    void testSubtract() {
        assertEquals(2, calculator.subtract(5, 3));
    }

    // Test for multiplication
    @Test
    void testMultiply() {
        assertEquals(15, calculator.multiply(5, 3));
    }

    // Test for division
    @Test
    void testDivide() {
        assertEquals(5, calculator.divide(10, 2));
    }
}

