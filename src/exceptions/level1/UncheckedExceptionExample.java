package javacollectionstreams.exceptionhandling.level1;
import java.util.Scanner;
import java.util.InputMismatchException;

public class UncheckedExceptionExample {

    public static void main(String[] args) {

        // Single-line comment:
        // Taking two numbers from the user
        Scanner sc = new Scanner(System.in);

        /*
         Multi-line comment:
         This program performs division of two numbers.
         It handles runtime exceptions like:
         1. ArithmeticException (division by zero)
         2. InputMismatchException (non-numeric input)
        */

        try {
            System.out.print("Enter numerator: ");
            int num1 = sc.nextInt();

            System.out.print("Enter denominator: ");
            int num2 = sc.nextInt();

            int result = num1 / num2;   // May throw ArithmeticException
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero");

        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter only numeric values");
        }
    }
}
