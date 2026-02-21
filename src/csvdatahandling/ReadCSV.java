package csvdatahandling;


import java.io.*;
import java.util.*;

public class ReadCSV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter CSV file name: ");
        String fileName = sc.nextLine();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            // Skip header
            br.readLine();

            System.out.println("\nStudent Records:\n");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                System.out.println("ID: " + data[0]);
                System.out.println("Name: " + data[1]);
                System.out.println("Age: " + data[2]);
                System.out.println("Marks: " + data[3]);
                System.out.println("-------------------");
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        sc.close();
    }
}
