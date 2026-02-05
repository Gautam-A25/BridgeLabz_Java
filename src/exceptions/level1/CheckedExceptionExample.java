package javacollectionstreams.exceptionhandling.level1;
import java.io.*;
import java.util.Scanner;

public class CheckedExceptionExample {

    public static void main(String[] args) {

        // Single-line comment:
        // Taking file name from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();

        /*
         Multi-line comment:
         This block tries to read the file.
         If the file does not exist,
         IOException will be handled.
        */
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);   // Checked exception
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}

