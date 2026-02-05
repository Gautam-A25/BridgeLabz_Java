package javacollectionstreams.exceptionhandling.level1;
import java.util.Scanner;

public class ThrowVsThrowsExample {

    /*
     Multi-line comment:
     This method calculates simple interest.
     It uses 'throws' to propagate exception.
     It uses 'throw' to explicitly throw exception.
    */
    static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {

        // Single-line comment:
        // Checking for invalid input
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        // Simple Interest formula
        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        System.out.print("Enter rate: ");
        double rate = sc.nextDouble();

        System.out.print("Enter years: ");
        int years = sc.nextInt();

        try {
            double interest = calculateInterest(amount, rate, years);
            System.out.println("Calculated Interest: " + interest);

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: Amount and rate must be positive");
        }
    }
}
