package javacollectionstreams.exceptionhandling.level1;
import java.util.Scanner;

// Custom Exception Class
class InvalidAgeException extends Exception {

    // Constructor to pass custom message
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomExceptionExample {

    /*
     Multi-line comment:
     This method checks whether the age is valid.
     If age is less than 18, it throws InvalidAgeException.
    */
    static void validateAge(int age) throws InvalidAgeException {

        // Single-line comment:
        // Checking age condition
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        } else {
            System.out.println("Access granted!");
        }
    }

    public static void main(String[] args) {

        // Taking user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        try {
            validateAge(age);   // Calling method
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}
