package csvdatahandling;

import java.io.*;
import java.util.*;

public class SortEmployees {

    // Employee class inside same file
    static class Employee {
        String id;
        String name;
        String dept;
        double salary;

        Employee(String id, String name, String dept, double salary) {
            this.id = id;
            this.name = name;
            this.dept = dept;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter employee CSV file name: ");
        String fileName = sc.nextLine();

        ArrayList<Employee> list = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            // Skip header
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String id = data[0];
                String name = data[1];
                String dept = data[2];
                double salary = Double.parseDouble(data[3]);

                list.add(new Employee(id, name, dept, salary));
            }

            br.close();

            // Sort by salary descending
            Collections.sort(list, (e1, e2) ->
                    Double.compare(e2.salary, e1.salary));

            System.out.println("\nTop 5 Highest Paid Employees:\n");

            for (int i = 0; i < Math.min(5, list.size()); i++) {
                Employee e = list.get(i);
                System.out.println("Name: " + e.name +
                        ", Department: " + e.dept +
                        ", Salary: " + e.salary);
            }

        } catch (Exception e) {
            System.out.println("Error reading file.");
        }

        sc.close();
    }
}
