package javacollectionstreams.exceptionhandling.level1;
import java.util.Scanner;

// Custom Checked Exception
class InsufficientBalanceException extends Exception {

    // Constructor
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {

    double balance = 5000;  // Initial balance

    /*
     Multi-line comment:
     This method withdraws amount from balance.
     It throws:
     1. InsufficientBalanceException if balance is low
     2. IllegalArgumentException if amount is negative
    */
    void withdraw(double amount) throws InsufficientBalanceException {

        // Single-line comment:
        // Checking for negative amount
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }

        // Checking for insufficient balance
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }

        // Performing withdrawal
        balance = balance - amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }
}

public class BankTransactionExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();

        // Taking user input
        System.out.print("Enter withdrawal amount: ");
        double amount = sc.nextDouble();

        try {
            account.withdraw(amount);

        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
