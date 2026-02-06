package javacollectionstreams.regex.basics.calculator;

public class Calculator {

    // Adds two numbers and returns the result
    public int add(int a, int b) {
        return a + b;
    }

    // Subtracts second number from first
    public int subtract(int a, int b) {
        return a - b;
    }

    // Multiplies two numbers
    public int multiply(int a, int b) {
        return a * b;
    }

    // Divides a by b, throws exception if b is zero
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}

