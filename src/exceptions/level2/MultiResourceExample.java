package javacollectionstreams.exceptionhandling.level2;
import java.io.*;
import java.util.Scanner;

public class MultiResourceExample {

    public static void main(String[] args) {

        // User input for file names
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first file: ");
        String f1 = sc.nextLine();
        System.out.print("Enter second file: ");
        String f2 = sc.nextLine();
        System.out.print("Enter output file: ");
        String out = sc.nextLine();

        /*
         Using multiple resources inside
         try-with-resources.
        */
        try (
                BufferedReader br1 = new BufferedReader(new FileReader(f1));
                BufferedReader br2 = new BufferedReader(new FileReader(f2));
                BufferedWriter bw = new BufferedWriter(new FileWriter(out))
        ) {

            String line;

            while ((line = br1.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

            while ((line = br2.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

            System.out.println("Files merged successfully!");

        } catch (IOException e) {
            System.out.println("File error occurred");
        }
    }
}

