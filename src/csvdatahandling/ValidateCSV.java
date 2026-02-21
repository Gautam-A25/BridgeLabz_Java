package csvdatahandling;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ValidateCSV {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter CSV file name: ");
        String fileName = sc.nextLine();

        // Email regex
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern emailPattern = Pattern.compile(emailRegex);

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String email = data[2];
                String phone = data[3];

                boolean emailValid = emailPattern.matcher(email).matches();
                boolean phoneValid = phone.matches("\\d{10}");

                if (!emailValid || !phoneValid) {
                    System.out.println("Invalid Row: " + line);
                }
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error reading file.");
        }

        sc.close();
    }
}
