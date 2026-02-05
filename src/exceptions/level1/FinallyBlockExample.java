package javacollectionstreams.exceptionhandling.level1;
import java.util.Scanner;

public class FinallyBlockExample {

    public static void main(String[] args) {

        // Single-line comment:
        // Taking user input
        Scanner sc = new Scanner(System.in);

        /*
         Multi-line comment:
         This program performs integer division.
         It demonstrates that the finally block
         always executes whether exception occurs or not.
        */

        try {
            System.out.print("Enter first number: ");
            int num1 = sc.nextInt();

            System.out.print("Enter second number: ");
            int num2 = sc.nextInt();

            int result = num1 / num2;   // May throw ArithmeticException
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");

        } finally {
            // This block always executes
            System.out.println("Operation completed");
        }
    }
}

