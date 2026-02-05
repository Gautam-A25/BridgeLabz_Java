package javacollectionstreams.exceptionhandling.level2;
import java.util.Scanner;

public class RethrowExample {

    /*
     This method performs division.
     Throws ArithmeticException if denominator is zero.
    */
    static int performDivision(int num, int den) {
        if (den == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return num / den;
    }

    /*
     This method catches and rethrows exception
     with additional context.
    */
    static int calculate(int num, int den) {
        try {
            return performDivision(num, den);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Error in calculate(): " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        // User input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter numerator: ");
        int n = sc.nextInt();
        System.out.print("Enter denominator: ");
        int d = sc.nextInt();

        try {
            int result = calculate(n, d);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Handled in main: " + e.getMessage());
        }
    }
}

