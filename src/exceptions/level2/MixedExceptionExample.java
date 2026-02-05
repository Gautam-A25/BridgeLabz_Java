package javacollectionstreams.exceptionhandling.level2;
import java.io.*;
import java.util.Scanner;

public class MixedExceptionExample {

    /*
     Throws checked and unchecked exceptions
    */
    static void processData(int value) throws IOException {
        if (value < 0) {
            throw new IllegalArgumentException("Negative value");
        }
        if (value == 0) {
            throw new IOException("IO problem occurred");
        }
        System.out.println("Data processed: " + value);
    }

    public static void main(String[] args) {

        // User input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value: ");
        int v = sc.nextInt();

        try {
            processData(v);
        } catch (IOException e) {
            System.out.println("Checked Exception: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Unchecked Exception: " + e.getMessage());
        }
    }
}

