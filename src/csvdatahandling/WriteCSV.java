package csvdatahandling;

import java.io.*;
import java.util.*;

public class WriteCSV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file name to create: ");
        String fileName = sc.nextLine();

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

            // Write header
            bw.write("ID,Name,Department,Salary");
            bw.newLine();

            for (int i = 1; i <= 5; i++) {
                System.out.println("\nEnter details for Employee " + i);

                System.out.print("ID: ");
                String id = sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Department: ");
                String dept = sc.nextLine();

                System.out.print("Salary: ");
                String salary = sc.nextLine();

                // Write data to file
                bw.write(id + "," + name + "," + dept + "," + salary);
                bw.newLine();
            }

            bw.close();
            System.out.println("\nFile created successfully!");

        } catch (IOException e) {
            System.out.println("Error writing file.");
        }

        sc.close();
    }
}
