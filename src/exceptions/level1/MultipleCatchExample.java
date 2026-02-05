package javacollectionstreams.exceptionhandling.level1;
import java.util.Scanner;

public class MultipleCatchExample {

    public static void main(String[] args) {

        // Single-line comment:
        // Declaring array reference
        int[] arr = null;

        Scanner sc = new Scanner(System.in);

        /*
         Multi-line comment:
         This program performs array operations.
         It retrieves a value from a given index.
         It handles:
         1. ArrayIndexOutOfBoundsException
         2. NullPointerException
        */

        try {
            // Asking user whether to initialize array
            System.out.print("Enter array size: ");
            int size = sc.nextInt();

            arr = new int[size];

            // Taking array elements
            System.out.println("Enter array elements:");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }

            // Taking index from user
            System.out.print("Enter index to retrieve value: ");
            int index = sc.nextInt();

            // Accessing array element
            System.out.println("Value at index " + index + ": " + arr[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");

        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }
}

