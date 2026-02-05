package javacollectionstreams.exceptionhandling.level2;
import java.util.Scanner;

/* Custom exception */
class TransactionException extends Exception {
    public TransactionException(String msg) {
        super(msg);
    }
}

public class TransactionProcessor {

    /*
     This method processes transaction.
     Rethrows exception with context.
    */
    static void processTransaction(int amount) throws TransactionException {
        try {
            if (amount < 0) {
                throw new IllegalArgumentException("Negative amount");
            }
        } catch (IllegalArgumentException e) {
            throw new TransactionException("Transaction failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        // User input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount: ");
        int amt = sc.nextInt();

        try {
            processTransaction(amt);
            System.out.println("Transaction successful");
        } catch (TransactionException e) {
            System.out.println(e.getMessage());
        }
    }
}
