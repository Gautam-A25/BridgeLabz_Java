package csvdatahandling;

import java.io.*;
import java.util.*;

public class CountRows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter CSV file name: ");
        String fileName = sc.nextLine();

        int count = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            // Skip header
            br.readLine();

            while ((line = br.readLine()) != null) {
                count++;
            }

            br.close();
            System.out.println("Total Records (excluding header): " + count);

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        sc.close();
    }
}

