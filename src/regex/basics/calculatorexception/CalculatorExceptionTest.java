package javacollectionstreams.regex.basics.calculatorexception;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorExceptionTest {

    // Calculator object
    Calculator calculator = new Calculator();

    // Test to check exception handling
    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        });
    }
}

