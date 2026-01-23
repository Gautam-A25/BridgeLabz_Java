/*
 This program reads user input from the console using InputStreamReader
 and writes each line into a file until the user types "exit".
*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class inputstreamreaderwritetofile {

    public static void main(String[] args) {

        String filePath = "output.txt"; // file to write user input

        // Try-with-resources to handle closing automatically
        try (
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                FileWriter writer = new FileWriter(filePath)
        ) {

            String input;

            System.out.println("Enter text (type 'exit' to stop):");

            // Read input until user types "exit"
            while (true) {
                input = br.readLine();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                // Write input to file as a new line
                writer.write(input + System.lineSeparator());
            }

            System.out.println("Input successfully written to file.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
