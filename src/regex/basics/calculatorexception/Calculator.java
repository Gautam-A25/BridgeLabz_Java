package javacollectionstreams.regex.basics.calculatorexception;

public class Calculator {

    // Division method that throws exception when divisor is zero
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}

