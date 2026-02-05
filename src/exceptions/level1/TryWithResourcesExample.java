package javacollectionstreams.exceptionhandling.level1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TryWithResourcesExample {

    public static void main(String[] args) {

        // Single-line comment:
        // Taking file name from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();

        /*
         Multi-line comment:
         This program reads the first line of a file
         using try-with-resources.
         The resource (BufferedReader) is automatically closed.
        */

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            // Reading first line
            String line = br.readLine();
            System.out.println("First line: " + line);

        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}

