package javacollectionstreams.exceptionhandling.level1;
import java.util.Scanner;

public class NestedTryCatchExample {

    public static void main(String[] args) {

        // Single-line comment:
        // Taking user input
        Scanner sc = new Scanner(System.in);

        /*
         Multi-line comment:
         This program demonstrates nested try-catch blocks.
         It first tries to access an array element.
         Then it tries to divide that element by a divisor.
        */

        try {
            // Input array size
            System.out.print("Enter array size: ");
            int size = sc.nextInt();

            int[] arr = new int[size];

            // Input array elements
            System.out.println("Enter array elements:");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }

            // Input index
            System.out.print("Enter index: ");
            int index = sc.nextInt();

            try {
                // Accessing array element
                int value = arr[index];

                // Input divisor
                System.out.print("Enter divisor: ");
                int divisor = sc.nextInt();

                // Division operation
                int result = value / divisor;
                System.out.println("Result: " + result);

            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        }
    }
}
