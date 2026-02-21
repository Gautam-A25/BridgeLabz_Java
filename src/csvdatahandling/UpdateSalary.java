package csvdatahandling;


import java.io.*;
import java.util.*;

public class UpdateSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter input CSV file name: ");
        String inputFile = sc.nextLine();

        System.out.print("Enter output CSV file name: ");
        String outputFile = sc.nextLine();

        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

            String line;

            // Write header
            line = br.readLine();
            bw.write(line);
            bw.newLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String department = data[2];
                double salary = Double.parseDouble(data[3]);

                if (department.equalsIgnoreCase("IT")) {
                    salary = salary + (salary * 0.10); // increase 10%
                }

                bw.write(data[0] + "," + data[1] + "," +
                        department + "," + salary);
                bw.newLine();
            }

            br.close();
            bw.close();

            System.out.println("Updated file created successfully!");

        } catch (Exception e) {
            System.out.println("Error processing file.");
        }

        sc.close();
    }
}
