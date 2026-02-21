package csvdatahandling;

import java.io.*;
import java.util.*;

public class SearchEmployee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter employee CSV file name: ");
        String fileName = sc.nextLine();

        System.out.print("Enter employee name to search: ");
        String searchName = sc.nextLine();

        boolean found = false;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data[1].equalsIgnoreCase(searchName)) {
                    System.out.println("\nEmployee Found!");
                    System.out.println("Department: " + data[2]);
                    System.out.println("Salary: " + data[3]);
                    found = true;
                    break;
                }
            }

            br.close();

            if (!found) {
                System.out.println("Employee not found.");
            }

        } catch (Exception e) {
            System.out.println("Error reading file.");
        }

        sc.close();
    }
}

