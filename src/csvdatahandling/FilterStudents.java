package csvdatahandling;

import java.io.*;
import java.util.*;

public class FilterStudents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student CSV file name: ");
        String fileName = sc.nextLine();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            br.readLine(); // skip header

            System.out.println("\nStudents scoring more than 80:\n");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int marks = Integer.parseInt(data[3]);

                if (marks > 80) {
                    System.out.println("ID: " + data[0] +
                            ", Name: " + data[1] +
                            ", Marks: " + marks);
                }
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error reading file.");
        }

        sc.close();
    }
}

